package org.nele.dao;

import org.nele.domain.Teacher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional//�Զ�ɨ�裬�Զ���������
public interface TeacherDao {
   public Teacher getTeacher(long id);
   public Teacher loginVerify(String tuserName,String tpassword);
   public void register(Teacher teacher);
}