package com.xxx.muluofeng;

import com.xxx.muluofeng.entities.User;
import com.xxx.muluofeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Administrator on 2016/12/15.
 */
@Controller
public class MyController {

    @Autowired
    UserService userService;

    @RequestMapping("/map")
    @ResponseBody
    public HashMap getMap() {
        HashMap map = new HashMap();
        map.put("name", "muluofeng");
        map.put("age", 24);
        return map;
    }

    @RequestMapping("/freemarker")
    public String freemarker(Map<String, Object> model) {
        QksdObj qksdObjOne = new QksdObj(1, "aaaa", new Date());
        QksdObj qksdObjTwo = new QksdObj(6, "bbbb", new Date());
        QksdObj qksdObjThree = new QksdObj(150000, "cccc", new Date());
        ArrayList QksdList = new ArrayList<QksdObj>();
        QksdList.add(qksdObjOne);
        QksdList.add(qksdObjTwo);
        QksdList.add(qksdObjThree);

        HashMap map = new HashMap<String, Object>();
        map.put("name", "muluofeng");
        map.put("age", 10099);

        Person person = new Person("muluofeng", qksdObjThree);

        model.put("time", new Date());
        model.put("name", "muluofeng");
        model.put("age", 100.123);
        model.put("qksdList", QksdList);
        model.put("mapdata", map);
        model.put("Person", person);
        return "welcome";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getdatatable() {
        return "datatable";
    }


    @RequestMapping(value = "user/data", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getUserData(
            int draw, int start, int length,
            @RequestParam("search[value]") String search) {
        Map<String, Object> map = new HashMap<String,Object>();
        List<User>  userList=userService.findAll();
        map.put("draw", draw);
        map.put("recordsTotal", 30);
        map.put("recordsFiltered",30);
        map.put("data", userList);
        return map;
    }


    @RequestMapping("/user/delete")
    @ResponseBody
    public ResultData<String> delete(@RequestParam(required=false)Integer id){
        userService.deleteById(id);
        ResultData  resultData=new ResultData();
        resultData.setMessage("删除成功");
        resultData.setSuccess(true);
        return resultData;
    }

}
