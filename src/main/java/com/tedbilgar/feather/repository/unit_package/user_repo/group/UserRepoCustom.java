package com.tedbilgar.feather.repository.unit_package.user_repo.group;

import com.tedbilgar.feather.domain.units.UserGroup;

import java.util.List;

public interface UserRepoCustom {
    List<UserGroup> getAllUserGroups();
    UserGroup getUserGroup(Long userId, Long groupId);
    List<UserGroup> getByUserId(Long userId);
    List<UserGroup> getByGroupId(Long groupId);
    void updateRelation(Long userId,Long groupId, String role);
    void deleteRelation(Long userId, Long groupId);
}
