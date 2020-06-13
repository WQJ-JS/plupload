package com.jusfoun.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jusfoun.plupload.Plupload;
import com.jusfoun.plupload.PluploadService;

@Controller
public class PluploadController {

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	/** Plupload文件上传处理方法 */
	@PostMapping(value = "/pluploadUpload")
	public void upload(Plupload plupload, HttpServletRequest request, HttpServletResponse response) {
		String FileDir = "H://upload";// 文件保存的文件夹
		plupload.setRequest(request);// 手动传入Plupload对象HttpServletRequest属性
		// 文件存储绝对路径,会是一个文件夹，项目相应Servlet容器下的"pluploadDir"文件夹，还会以用户唯一id作划分
		File dir = new File(FileDir);
		if (!dir.exists()) {
			dir.mkdirs();// 可创建多级目录，而mkdir()只能创建一级目录
		}
		try {
			// 开始上传文件
			PluploadService.upload(plupload, dir);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
