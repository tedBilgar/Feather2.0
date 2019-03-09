package com.tedbilgar.feather.repository.unit_package.user_repo.tasklist;

import com.tedbilgar.feather.domain.task_units_relation.UserTaskList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskListCustomImpl implements TaskListCustom{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserTaskList> findAllUserTaskLists() {
        Query query = entityManager.createNativeQuery("select * from user_tasklist as utl ", UserTaskList.class);
        return query.getResultList();
    }

    @Override
    public UserTaskList findUserTaskList(Long userId, Long tasklistId) {
        Query query = entityManager.createNativeQuery("select * from user_tasklist as utl  where user_id = :userId and tasklist_id = :tasklistId", UserTaskList.class);
        query.setParameter("userId",userId);
        query.setParameter("tasklistId", tasklistId);
        return (UserTaskList) query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<UserTaskList> findAllUsersByTaskList(Long taskListId) {
        Query query = entityManager.createNativeQuery("select * from user_tasklist as utl where tasklist_id = :taskListId", UserTaskList.class);
        query.setParameter("taskListId",taskListId);
        return query.getResultList();
    }

    @Override
    public List<UserTaskList> findAllTaskListsByUser(Long userId) {
        Query query = entityManager.createNativeQuery("select * from user_tasklist as utl where user_id = :userId", UserTaskList.class);
        query.setParameter("userId",userId);
        return query.getResultList();
    }

    @Override
    public void deleteRelationUserTaskList(Long userId, Long taskListId) {
        Query query = entityManager.createNativeQuery("delete from user_tasklist as utl where tasklist_id = :taskListId and user_id = :userId ", UserTaskList.class);
        query.setParameter("taskListId", taskListId);
        query.setParameter("userId",userId);
        query.executeUpdate();
    }
}
