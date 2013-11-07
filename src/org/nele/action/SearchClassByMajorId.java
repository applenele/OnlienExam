package org.nele.action;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.ClassDao;
import org.nele.domain.Class;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller//���� Spring����
@Scope("prototype") //�����ķ�ʽ
public class SearchClassByMajorId extends ActionSupport {
       @Resource ClassDao classDaoImpl;//ע��classDao�ӿ�
       private String majorId;
       private String result;
       @JSON(serialize=false)
       public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@JSON(serialize=false)
       public String getMajorId() {
		return majorId;
	}
	public void setMajorId(String majorId) {
		this.majorId = majorId;
	}
	public String execute(){
    	 int majorIdInt=Integer.parseInt(majorId);//��ǰ̨�õ���majorId�ַ�תת��int��
    	   
    	List<Class> list=classDaoImpl.getAllClassBymajorId(majorIdInt);//���ýӿڵķ����õ�majorId����Ҫ���ȫ����classde����
    	JSONArray jsonArray=JSONArray.fromObject(list);//��list����ת����json�ĸ�ʽ
    	this.setResult(jsonArray.toString());//��json��ʽ��listת�����ַ�������result�����ڷ��ظ�ǰ̨
    	   return SUCCESS;
       }
}
