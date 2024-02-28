package com.cbh.ojbackendjudgeservice.judge.codesandbox;


import com.cbh.ojbackendjudgeservice.judge.codesandbox.impl.ExampleCodeSandbox;
import com.cbh.ojbackendjudgeservice.judge.codesandbox.impl.RemoteCodeSandbox;
import com.cbh.ojbackendjudgeservice.judge.codesandbox.impl.ThirdCodeSandbox;

/**
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱示例
     * @param type
     * @return
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }

    }
}
