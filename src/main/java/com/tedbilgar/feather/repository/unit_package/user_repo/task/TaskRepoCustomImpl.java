package com.tedbilgar.feather.repository.unit_package.user_repo.task;

import com.tedbilgar.feather.domain.task_units_relation.UserTask;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TaskRepoCustomImpl implements TaskRepoCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserTask> findAllUserTasks() {
        Query query = entityManager.createNativeQuery("select * from user_task as ut  ", UserTask.class);
        return query.getResultList();
    }

    @Override
    public UserTask findUserTask(Long userId, Long taskId) {
        Query query = entityManager.createNativeQuery("select * from user_task as ut where user_id = :userId and task_id = :taskId", UserTask.class);
        query.setParameter("userId",userId);
        query.setParameter("taskId",taskId);
        return (UserTask) query.getResultStream().findFirst().orElse(null);
    }

    @Override
    public List<UserTask> findAllUsersByTask(Long taskId) {
        Query query = entityManager.createNativeQuery("select * from user_task as ut where task_id = :taskId", UserTask.class);
        query.setParameter("taskId",taskId);
        return query.getResultList();
    }

    @Override
    public List<UserTask> findAllTasksByUser(Long userId) {
        Query query = entityManager.createNativeQuery("select * from user_task as ut where user_id = :userId", UserTask.class);
        query.setParameter("userId",userId);
        return query.getResultList();
    }

    @Override
    public void deleteRelationUserTask(Long userId, Long taskId) {
        Query query = entityManager.createNativeQuery("delete from user_task as ut where task_id = :taskId and user_id = :userId ", UserTask.class);
        query.setParameter("taskId", taskId);
        query.setParameter("userId",userId);
        query.executeUpdate();
    }
}
