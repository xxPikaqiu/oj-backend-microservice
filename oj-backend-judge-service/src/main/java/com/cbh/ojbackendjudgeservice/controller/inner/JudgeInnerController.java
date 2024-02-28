package com.cbh.ojbackendjudgeservice.controller.inner;

import com.cbh.ojbackendjudgeservice.judge.JudgeService;
import com.cbh.ojbackendmodel.model.entity.Question;
import com.cbh.ojbackendmodel.model.entity.QuestionSubmit;
import com.cbh.ojbackendserviceclient.service.JudgeFeignClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * 该服务仅内部调用，不是给前端的
 */
@RestController
@RequestMapping("/inner")
public class JudgeInnerController implements JudgeFeignClient {

    @Resource
    private JudgeService judgeService;

    /**
     * 判题
     * @param questionSubmitId
     * @return
     */
    @Override
    @PostMapping("/do")
    public QuestionSubmit doJudge(@RequestParam("questionSubmitId") long questionSubmitId){
        return judgeService.doJudge(questionSubmitId);
    }
}
