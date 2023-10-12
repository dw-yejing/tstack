package edu.bjtu.elasticsearch.vo;

import lombok.Data;

import java.util.List;

@Data
public class OperateContentVo {
    private List<String> backOfficeIds;
    private List<String> backOfficeNames;
    private String deadlineDate;
    private List<String> officeIds;
    private List<String> officeNames;
    private String opinion;
}
