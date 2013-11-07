package org.nele.dao;

import java.util.List;

import org.nele.domain.Class;

public interface ClassDao {
   public List<Class> getAllClassBymajorId(int majorId);
   
   public Class getClassById(int classId);
}
