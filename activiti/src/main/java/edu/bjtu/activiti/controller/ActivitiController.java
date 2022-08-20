package edu.bjtu.activiti.controller;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@AllArgsConstructor
public class ActivitiController {
    private RepositoryService repositoryService;
    private ObjectMapper objectMapper;
    private static final String BPMN20_XML = ".bpmn20.xml";

    /**
     * 新建模型
     */
    @PostMapping("/model/save")
    public void saveModel(String name, String key, String desc, String category) {
        Model model = repositoryService.newModel();
        int version = (int) repositoryService.createModelQuery().modelKey(key).count();

        model.setKey(key);
        model.setName(name);
        model.setCategory(category);
        model.setVersion(++version);
        ObjectNode modelObjectNode = objectMapper.createObjectNode();
        modelObjectNode.put(ModelDataJsonConstants.MODEL_NAME, name);
        modelObjectNode.put(ModelDataJsonConstants.MODEL_REVISION, model.getVersion());
        modelObjectNode.put(ModelDataJsonConstants.MODEL_DESCRIPTION, desc);
        model.setMetaInfo(modelObjectNode.toString());

        repositoryService.saveModel(model);
    }

    /**
     * 增加模型的流程
     */
    @PostMapping("/model/source/add")
    public void addModelSource(String modelId, String jsonXml) {
        repositoryService.addModelEditorSource(modelId, jsonXml.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 部署模型
     */
    @PutMapping("/model/deploy")
    public void deploy(String id, String category) throws Exception {
        Model model = repositoryService.getModel(id);
        ObjectNode objectNode = (ObjectNode) new ObjectMapper().readTree(repositoryService.getModelEditorSource(model.getId()));
        BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(objectNode);
        String processName = model.getName();
        if (!StrUtil.endWithIgnoreCase(processName, BPMN20_XML)) {
            processName += BPMN20_XML;
        }
        // 部署流程
        repositoryService
                .createDeployment()
                .name(model.getName())
                .addBpmnModel(processName, bpmnModel)
                .category(category)
                .deploy();
    }
}
