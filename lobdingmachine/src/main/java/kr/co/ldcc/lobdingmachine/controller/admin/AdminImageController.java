package kr.co.ldcc.lobdingmachine.controller.admin;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.ldcc.lobdingmachine.controller.BaseController;
import kr.co.ldcc.lobdingmachine.dao.ImageDao;
import kr.co.ldcc.lobdingmachine.model.image.Image;

@Controller
@RequestMapping("/admin/image")
public class AdminImageController extends BaseController {
	
	@Value("${file.upload.path}") String filePath;
	@Value("${file.upload.url}") String fileUrl;
	
	@Autowired ImageDao dao;

	@RequestMapping(value = { "", "/" })
	public String imageUploadPage() {
		return "admin/image/main";
	}

	// http://gangzzang.tistory.com/entry/%EC%8A%A4%ED%94%84%EB%A7%81Spring-%ED%8C%8C%EC%9D%BC-%EC%97%85%EB%A1%9C%EB%93%9CFile-Upload
	@RequestMapping("/upload")
	public String upload(MultipartFile multipartFile, RedirectAttributes attr) {
		if(multipartFile != null) {
			String fileName = multipartFile.getOriginalFilename();
			try {
				File file = new File(filePath + fileName);
				multipartFile.transferTo(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			dao.insert(new Image(fileUrl+fileName));
			attr.addFlashAttribute("url", fileUrl+fileName);
		}
		return "redirect:/admin/image";

	}

}
