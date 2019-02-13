package com.cqkj.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cqkj.bean.PageList;
import com.cqkj.bean.Scores;
import com.cqkj.bean.TCourse;
import com.cqkj.bean.TSC;
import com.cqkj.bean.UserInfo;
import com.cqkj.service.ScoresService;
import com.cqkj.service.TCourseService;
import com.cqkj.service.TSCService;
import com.cqkj.service.UserInfoService;

/**
 * 成绩管理和选课统计控制器
 * 
 * @author LSL
 * @createDate 2019年2月9日
 * @lastUpdateDate 2019年2月9日
 * @version 1.0
 */
@Controller
public class ScoreController
{
    @Resource
    UserInfoService userInfoService;

    @Resource
    TCourseService tCourseService;

    @Resource
    ScoresService scoresService;

    @Resource
    PageList<Scores> pageList;

    @Resource
    TSCService tscService;

    /**
     * 成绩管理
     * 
     * @return
     */
    @GetMapping("/score")
    public String score()
    {
        return "view/score/score";
    }

    /**
     * 选课统计
     * 
     * @return
     */
    @GetMapping("/scCount")
    public String scCount()
    {
        return "view/SCCount/scCount";
    }

    /**
     * 查询学生
     * 
     * @return
     * @throws Exception
     */
    @PostMapping("/getStu")
    @ResponseBody
    public List<UserInfo> getStu() throws Exception
    {
        return userInfoService.selectStudentService();
    }

    /**
     * 查询学生所选择的课程
     * 
     * @param stuId
     * @return
     * @throws Exception
     */
    @PostMapping("/getCou")
    @ResponseBody
    public List<TCourse> getCou(Integer stuId) throws Exception
    {
        return tCourseService.getSelectCourse(stuId);
    }

    /**
     * 查询课程分数等信息
     * 
     * @param pageIndex
     * @param stuId
     * @return
     * @throws Exception
     */
    @PostMapping("/selectScore")
    @ResponseBody
    public PageList<Scores> select(Integer pageIndex, Integer stuId) throws Exception
    {
        pageList.setPageIndex(pageIndex);

        // 若stuId为空，则表示是成绩管理信息，否则则是选课统计信息
        if (stuId == null)
        {
            scoresService.selectScoresService(pageList);
        } else
        {
            scoresService.selectScoresService(pageList, stuId);
        }

        return pageList;
    }

    /**
     * 修改分数
     * 
     * @param stuId
     * @param cId
     * @param score
     * @return
     * @throws Exception
     */
    @PostMapping("/updateScore")
    @ResponseBody
    public String update(Integer stuId, Integer cId, Double score) throws Exception
    {
        TSC tsc = tscService.getTSCService(stuId, cId);

        tsc.setScore(score);

        if (tscService.updateTSC(tsc))
        {
            return "Y";
        } else
        {
            return "N";
        }
    }
}
