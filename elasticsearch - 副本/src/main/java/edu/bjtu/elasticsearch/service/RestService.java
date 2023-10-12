package edu.bjtu.elasticsearch.service;

import edu.bjtu.elasticsearch.vo.ResultVO;

public interface RestService {
    ResultVO search();

    ResultVO aggregate();

    ResultVO addDoc();

    ResultVO updateDoc();
}
