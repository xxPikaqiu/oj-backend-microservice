package com.cbh.ojbackendjudgeservice.judge.codesandbox;

import com.cbh.ojbackendmodel.model.codesandbox.ExecuteCodeRequest;
import com.cbh.ojbackendmodel.model.codesandbox.ExecuteCodeResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: cbh
 * @Date: 2024-02-04 9:29
 */
@Slf4j
public class CodeSandboxProxy implements CodeSandbox{


    private final CodeSandbox codeSandbox;

    public CodeSandboxProxy(CodeSandbox codeSandbox) {
        this.codeSandbox = codeSandbox;
    }


    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        log.info("代码沙箱请求信息：" + executeCodeRequest.toString());
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        log.info("代码沙箱响应信息：" + executeCodeResponse.toString());
        return executeCodeResponse;
    }

}
