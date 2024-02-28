package com.cbh.ojbackendjudgeservice.judge.codesandbox;


import com.cbh.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.cbh.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}