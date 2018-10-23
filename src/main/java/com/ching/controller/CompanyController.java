package com.ching.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ching.entity.Company;
import com.ching.services.Companyser;

@Controller
@RequestMapping("/company/")
public class CompanyController {

	@Resource(name="companyser")
	private Companyser companyser;
	
	@RequestMapping("test")
	public String test(){
		
		return "success";
	}
	
	
	@RequestMapping("test1")
	public String test1(){
		return "forward:test.do";
	}

	/*redirect: ���� forward: �����ӳ�����֣��Ӷ������ض�������ط�*/
	
	
	
	//��ֵ����1��ʹ��servlet���request session��
	@RequestMapping("findall")
	public String findall(HttpServletRequest request,HttpServletResponse response){
		List<Company> list = companyser.findPersonAll();
		HttpSession session  =  request.getSession();
		session.setAttribute("zhi", list);
		/*request.setAttribute("zhi", list);*/
		return "findall";
	}
	
	
	//ͨ��Model������в�����ȡֵ��Ȼʹ��el���ʽ
	@RequestMapping("findall1")
	public String findall1(Model model){
		List<Company> list = companyser.findPersonAll();
		model.addAttribute("zhi", list);
		return "findall";
	}
	//ͨ��ModelAndView��ֵ��ͼģ��---�����и���ͼ������
	@RequestMapping("findall2")
	public ModelAndView findall2(ModelAndView model){
		List<Company> list = companyser.findPersonAll();
		model.setViewName("findall");
		model.addObject("zhi", list);
		return model;
	}
	//json��ֵAjax��ز���
	
	@RequestMapping("ajaxtest")
	@ResponseBody
	public String ajaxtest(HttpServletRequest request,HttpServletResponse response){
	String str =(String)request.getParameter("haha");
		System.out.println("=================");
		System.out.println(str);
		return "asd";
	}	
	
	//��ʽ������ģʽҪ��ʹ��get��������һ�㶼��post��ʱʹ��servlet����
	@RequestMapping("ajaxtest1")
	@ResponseBody
	public String ajaxtest1(@RequestParam("haha")String haha){
		
		System.out.println(	haha);
		return "asd123";
	}	
	
	//����������json,����json���ݣ�����ֱ�ӷ��ض�����߷���map
	@RequestMapping("ajaxtest2")
	@ResponseBody
	public /*Map*/ Company ajaxtest2(HttpServletRequest    request,HttpServletResponse response){
		System.out.println(request.getAttribute("name"));
		
        System.out.println(request.getAttribute("age"));

        Map<String,Object> map = new HashMap<String,Object>(); 

        map.put("name","С��"); 

        map.put("age","30");
        
        Company com = new Company("c13", "�����", "����", "132123", "sfdsfsdf", "dsff", null);
		return com;
	}	
	
	//ǰ̨jsonת�ַ���
	@RequestMapping("ajaxtest3")
	@ResponseBody
	public String ajaxtest3(@RequestBody Company company){
		
		System.out.println(	company.getCity());
		System.out.println(	company.getName());
		
		return "asd123";
	}	
	
	@RequestMapping("formtest")
	@ResponseBody
	public String formtest(Company p){
	
		companyser.addPerson(p);
		return "success";
	}	
	
	
	@RequestMapping("formtest2")
	@ResponseBody
	public String formtest2(@Validated Company p,BindingResult br){
		boolean flag = br.hasErrors();
		if(flag){
		List<FieldError> list = br.getFieldErrors();
		
		for(FieldError error:list){
			System.out.println(error.getDefaultMessage());
		}
		
		return "error";}else{
			companyser.addPerson(p);
			return "success";
		}
		
	}
		
		
		
		//�ļ��ϴ����ز���
		//�����ļ��Ĳ����������ļ�nameһ�£����ļ��ϴ���������Ϊname��ֵ����Ϊkey��
		@RequestMapping("upfile")
		public void fileupload(MultipartFile file,HttpServletRequest request) throws Exception{
		/*	String name = file.getName();
			String oname = file.getOriginalFilename();
			System.out.println(name +"   "+oname);
			file.transferTo(new File("E:\\ching�ܽ�\\"+oname));*/
			String path = request.getRealPath("\\front");
		/*	String rep = request.getServletContext().getRealPath("\\front");*/
			String name = file.getName();//�õ�����
			String oname = file.getOriginalFilename();//�õ��ļ�����
			String filename= path+"\\"+UUID.randomUUID().toString()+oname;
			System.out.println(filename);
			System.out.println(oname);
		file.transferTo(new File(filename));
	}
		

		public void testUUID(){
			//����+ʱ���
			String ssUUID = UUID.randomUUID().toString();
			System.out.println(ssUUID);
		}
		
		//���ļ� �ϴ� MultipartRequest
		@RequestMapping("upfiles")
		public void fileuploads(MultipartRequest files,HttpServletRequest request) throws Exception{
			Map<String, MultipartFile> map  =  files.getFileMap();
			Set<String> keys = map.keySet();
		/*	Collection<MultipartFile> ff =map.values();
			for(MultipartFile f : ff){
			System.out.println(f.getOriginalFilename());
			}*/
			for(String key:keys){
				MultipartFile file = map.get(key);
				String oname = file.getOriginalFilename();
				String uuid = UUID.randomUUID().toString();
				String path = request.getServletContext().getRealPath("\\front")+"\\"+uuid+oname;
				file.transferTo(new File(path));
				System.out.println(path);
			}
			
			System.out.println("�ɹ�");
		
		}
		
		
		@RequestMapping("upfile1")
		public void fileupload1(MultipartFile[] files,HttpServletRequest request) throws Exception{
		/*	String name = file.getName();
			String oname = file.getOriginalFilename();
			System.out.println(name +"   "+oname);
			file.transferTo(new File("E:\\ching�ܽ�\\"+oname));*/
			String path = request.getRealPath("\\front");
		/*	String rep = request.getServletContext().getRealPath("\\front");*/
			for(MultipartFile file:files){
			String name = file.getName();//�õ�����
			String oname = file.getOriginalFilename();//�õ��ļ�����
			String filename= path+"\\"+UUID.randomUUID().toString()+oname;
			System.out.println(filename);
			System.out.println(oname);
		file.transferTo(new File(filename));
		}
	}
		
		
		
		@RequestMapping("filexz")
		//��һ��ʵ��ResponseEntity
		public ResponseEntity<byte[]> filexz(HttpServletRequest request,HttpServletResponse response) throws Exception{
			String rep = request.getServletContext().getRealPath("\\front");
			/*String fileName = URLEncoder.encode("����.pdf","utf-8");*/
			/*String filename=  new String("����.pdf", "sf", "utf-8");*/
			 File file = new File(rep+"\\"+"����.pdf");
			     byte[] body = null;
			     //���ļ�д������
			     InputStream is = new FileInputStream(file);
			     body = new byte[is.available()];
			     is.read(body);
			 	//�ڶ���ʵ��HttpHeaders
			     HttpHeaders headers = new HttpHeaders();
			     /*headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);  */
			     //����ͷ�е���Ϣ---����Ҫת��һ�¡�
			     System.out.println(file.getName());
			     headers.add("Content-Disposition", "attchement;filename="+URLEncoder.encode(file.getName(),"utf-8"));
			     //����״̬
			     HttpStatus statusCode = HttpStatus.OK;
			     //���һ��responseEntry
			     ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
			     return entity;
			 }
		
		
		
		@RequestMapping("filexz2")
		public void filexz2(HttpServletRequest request,HttpServletResponse response) throws Exception{
			String rep = request.getServletContext().getRealPath("\\front");
			
			
			
			request.setCharacterEncoding("UTF-8");  
		    BufferedInputStream bis = null;  
		    BufferedOutputStream bos = null;  
		  
		    //��ȡ��Ŀ��Ŀ¼
		    String ctxPath = request.getSession().getServletContext()  
		        .getRealPath("");  
		    
		    //��ȡ�����ļ�¶��
		    String downLoadPath = ctxPath+"/uploadFile/"+ "����.pdf";  
		  
		    //��ȡ�ļ��ĳ���
		    long fileLength = new File(downLoadPath).length();  

		    //�����ļ��������
		    response.setContentType("application/octet-stream");  
		    response.setHeader("Content-disposition", "attachment; filename="  
		        + URLEncoder.encode("����.pdf","utf-8")); 
		    //�����������
		    response.setHeader("Content-Length", String.valueOf(fileLength));  
		    //��ȡ������
		    bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
		    //�����
		    bos = new BufferedOutputStream(response.getOutputStream());  
		    byte[] buff = new byte[2048];  
		    int bytesRead;  
		    while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
		      bos.write(buff, 0, bytesRead);  
		    }  
		    //�ر���
		    bis.close();  
		    bos.close();  
		  }  
			
		
}
	 
			 
			 

		
		
		
		
	
	

