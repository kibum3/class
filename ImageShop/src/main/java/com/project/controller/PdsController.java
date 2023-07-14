package com.project.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.common.util.UploadFileUtils;
import com.project.domain.Pds;
import com.project.service.PdsService;

@Controller
@RequestMapping("/pds")
public class PdsController {

	@Autowired
	private PdsService pdsService;

	@Value("${upload.path}")
	private String uploadPath;

	// 목록 화면
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list(Model model) throws Exception {
		List<Pds> itemList = this.pdsService.list();

		model.addAttribute("itemList", itemList);
	}

	// 등록 화면
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String registerForm(Model model) {
		model.addAttribute(new Pds());

		return "pds/register";
	}

	// 등록 처리
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String register(Pds pds, RedirectAttributes rttr) throws Exception {
		this.pdsService.register(pds);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/pds/list";
	}
	
	// 상세 화면
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(Integer itemId, Model model) throws Exception {
		Pds pds = this.pdsService.read(itemId);

		model.addAttribute(pds);

		return "pds/read";
	}
	
	// 첨부파일 업로드 처리
	@ResponseBody
	@RequestMapping(value = "/uploadAjax", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception {
		String savedName = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());

		return new ResponseEntity<String>(savedName, HttpStatus.CREATED);
	}

	// 첨부파일 다운로드 처리
	@ResponseBody
	@RequestMapping("/downloadFile")
	public ResponseEntity<byte[]> downloadFile(String fullName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		// 첨부파일 다운로드 건수 업데이트
		pdsService.updateAttachDownCnt(fullName);

		try {
			HttpHeaders headers = new HttpHeaders();

			in = new FileInputStream(uploadPath + fullName);

			String fileName = fullName.substring(fullName.indexOf("_") + 1);
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition", "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");

			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		
		return entity;
	}

	// 첨부파일 목록 조회
	@ResponseBody
	@RequestMapping("/getAttach/{itemId}")
	public List<String> getAttach(@PathVariable("itemId") Integer itemId) throws Exception {
		return pdsService.getAttach(itemId);
	}
	

    // 수정 화면
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modifyForm(Integer itemId, Model model) throws Exception {
		Pds pds = this.pdsService.read(itemId);

		model.addAttribute(pds);

		return "pds/modify";
	}

    // 수정 처리
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String modify(Pds pds, RedirectAttributes rttr) throws Exception {
		this.pdsService.modify(pds);

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/pds/list";
	}

    // 삭제 화면
	@RequestMapping(value = "/remove", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String removeForm(Integer itemId, Model model) throws Exception {
		Pds pds = this.pdsService.read(itemId);

		model.addAttribute(pds);

		return "pds/remove";
	}

	// 삭제 처리
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public String remove(Pds pds, RedirectAttributes rttr) throws Exception {
		this.pdsService.remove(pds.getItemId());

		rttr.addFlashAttribute("msg", "SUCCESS");

		return "redirect:/pds/list";
	}
	
}
