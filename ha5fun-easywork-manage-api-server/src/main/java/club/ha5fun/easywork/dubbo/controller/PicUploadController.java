//package club.ha5fun.easywork.dubbo.controller;
//
//import club.ha5fun.easywork.dubbo.service.PicUploadFileSystemService;
//import club.ha5fun.easywork.dubbo.vo.PicUploadResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
///**
// * @author chen
// * @Company ha5fun.club
// */
//@RequestMapping("pic/upload")
//@Controller
//public class PicUploadController {
//
//    @Autowired
//    private PicUploadFileSystemService picUploadFileSystemService;
//
//    @PostMapping
//    @ResponseBody
//    public PicUploadResult upload(@RequestParam(value="File") MultipartFile multipartFile){
//
//
//        return this.picUploadFileSystemService.upload(multipartFile);
//    }
//}
