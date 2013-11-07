package org.nele.dao;

import java.util.List;

import org.nele.domain.XueYuan;

public interface XueYuanDao {
	public List<XueYuan> getAllXueYuan();
	public XueYuan getXueYuanById(int XyId);
}
