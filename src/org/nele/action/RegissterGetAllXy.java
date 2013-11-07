package org.nele.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.json.annotations.JSON;
import org.nele.dao.ClassDao;
import org.nele.dao.MajorDao;
import org.nele.dao.XueYuanDao;
import org.nele.domain.Class;
import org.nele.domain.Major;
import org.nele.domain.XueYuan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller  @Scope("prototype")
public class RegissterGetAllXy extends ActionSupport {
    @Resource XueYuanDao xueYuanDaoImpl;
    @Resource MajorDao majorDaoImpl;
    @Resource ClassDao classDaoImpl;
    private String result;
    private List<Class> bjList;
	private List<XueYuan> list;
    private List<Major> majorList;
    private int xyId;
    private int majorId;
    @JSON(serialize=false)
    public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	@JSON(serialize=false)
    public List<Class> getBjList() {
		return bjList;
	}
	public void setBjList(List<Class> bjList) {
		this.bjList = bjList;
	}
    @JSON(serialize=false)
    public int getXyId() {
		return xyId;
	}
	public void setXyId(int xyId) {
		this.xyId = xyId;
	}
	@JSON(serialize=false)
    public List<Major> getMajorList() {
		return majorList;
	}
	public void setMajorList(List<Major> majorList) {
		this.majorList = majorList;
	}
	private Map<String,String> map;
    @JSON(serialize=false)
    public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	@JSON(serialize=false)
    public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String execute(){
		map=new HashMap<String, String>();
    	list=xueYuanDaoImpl.getAllXueYuan();
    	majorList=majorDaoImpl.getAllMajorByXueYuanId(xyId);
    	bjList=classDaoImpl.getAllClassBymajorId(majorId);
    	JSONArray listjsonOArray=JSONArray.fromObject(list);
    	JSONArray majorListjsonArray=JSONArray.fromObject(majorList);
    	JSONArray bjLsitjsonArray=JSONArray.fromObject(bjList);
    	map.put("xueYuan", listjsonOArray.toString());
    	map.put("major", majorListjsonArray.toString());
    	map.put("bj", bjLsitjsonArray.toString());
    	//this.setResult(jsonOArray.toString());
    	return SUCCESS;
    }
}
