package org.nele.dao;

import java.util.List;

import org.nele.domain.Major;

public interface MajorDao {
   public List<Major> getAllMajorByXueYuanId(int xyId);
   public Major getMajorById(int MajorId);
}
