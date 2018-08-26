package com.neuedu.controller;

import com.neuedu.entity.Student;
import com.neuedu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/stu")
public class stuController {
    @Autowired
    StudentService studentService;

    /*
     * 查询所有*/
    @RequestMapping(value = "/find")
    public ModelAndView findall(ModelAndView modelAndView) {
        List <Student> StudentMapper = studentService.findall();
        modelAndView.addObject("stus", StudentMapper);
        modelAndView.setViewName("stu");
        return modelAndView;
    }

    /*json*/
    @RequestMapping(value = "/findjson")
    public @ResponseBody
    List <Student> findall() {
        List <Student> StudentMapper = studentService.findall();
        return StudentMapper;
    }


    @RequestMapping(value = "delete/{stumun}")
    public String delete(@PathVariable("stumun") String stumun) {
        int i = studentService.deleteByPrimaryKey(stumun);
        return "forward:stu/find";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView modelAndView) {
        List <Student> StudentMapper = studentService.findall();
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("stus", StudentMapper);
        modelAndView.setViewName("addstu2");//逻辑视图
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid Student student, BindingResult bindingResult, @RequestParam("upload") MultipartFile upload) {
 if(bindingResult.hasErrors()){
     return "addstu2";
 }
        //        //处理图片
//        //原始名称
//        String  originalFilename=upload.getOriginalFilename();
//        //上传图片
//        if (upload!=null&&originalFilename!=null&&originalFilename.length()>0){
//            String pic_path="F:/imgs/";
//            //新的图片名称
//            String  newFileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
//            //新图片
//            File  newFile =new File(pic_path+newFileName);
//            //将内存中的数据写入磁盘
//            try {
//                upload.transferTo(newFile);
//                //图片路径
//                String  url="http://localhost:8080/uploadpic/"+newFileName;
//                Student  stu=new Student();
//                stu.setTouxiang(url);
//                stu.setStuname(stuname);
//                stu.setStunum(stunum);
//                stu.setBanji(banji);
//                studentService.insert(stu);
//                return  "forward:find";
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("777777777777");
        System.out.println(student);
        return "forward:find";
    }

    //    @RequestMapping(value = "/add",method = RequestMethod.POST   )
//    public String add(String stunum, String stuname, String banji, @RequestParam("upload") MultipartFile upload)  {
//        //处理图片
//        //原始名称
//         String  originalFilename=upload.getOriginalFilename();
//         //上传图片
//         if (upload!=null&&originalFilename!=null&&originalFilename.length()>0){
//            String pic_path="F:/imgs/";
//            //新的图片名称
//            String  newFileName= UUID.randomUUID()+originalFilename.substring(originalFilename.lastIndexOf("."));
//       //新图片
//             File  newFile =new File(pic_path+newFileName);
//             //将内存中的数据写入磁盘
//             try {
//                 upload.transferTo(newFile);
//                 //图片路径
//            String  url="http://localhost:8080/uploadpic/"+newFileName;
//                 Student  stu=new Student();
//                 stu.setTouxiang(url);
//                 stu.setStuname(stuname);
//                 stu.setStunum(stunum);
//                 stu.setBanji(banji);
//                 studentService.insert(stu);
//                 return  "forward:find";
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }
//         }
//        return  "forward:find";
//    }
    @RequestMapping(value = "/update/{stumun}", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable("stumun") String stumun, ModelAndView modelAndView) {
        Student stu = studentService.selectByPrimaryKey(stumun);
        List <Student> StudentMapper = studentService.findall();
        modelAndView.addObject("smp", StudentMapper);
        modelAndView.addObject("stus", stu);
        modelAndView.setViewName("update");//逻辑视图
        return modelAndView;
    }

    @RequestMapping(value = "/update/{stumun}", method = RequestMethod.POST)
    public String update(@PathVariable("stumun") String stunum, String stuname, String banji) {
        Student stu = new Student();
        stu.setStuname(stuname);
        stu.setStunum(stunum);
        stu.setBanji(banji);
        studentService.updateByPrimaryKey(stu);
        return "forward:stu/find";
    }
}
