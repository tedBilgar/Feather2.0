package com.tedbilgar.feather.repository.user_repo;

import com.tedbilgar.feather.domain.units.UserGroup;

import java.util.List;
import java.util.Set;

public interface UserRepoCustom {
    List<UserGroup> getAllUserGroups();
    List<UserGroup> getByUserId(Long userId);
    List<UserGroup> getByGroupId(Long groupId);
    void updateRelation(Long userId,Long groupId, String role);
    void deleteRelation(Long userId, Long groupId);
}
