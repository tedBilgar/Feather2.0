package com.tedbilgar.feather.repository.unit_package.user_repo.desk;

import com.tedbilgar.feather.domain.task_units_relation.UserDesk;

import java.util.List;

public interface DeskRepoCustom {
    List<UserDesk> findAllUserDesks();
    List<UserDesk> findAllUserByDesk(Long deskId);
    List<UserDesk> findAllDeskByUser(Long userId);

    void deleteRelationUserDesk(Long userId,Long deskId);
}
