package com.els.base.member.service.member;

import java.util.List;

import com.els.base.member.entity.member.Member;

public interface MemberFollowerService {
	
	public void follow(Member parent, Member children);
	
	public void unFollow(Member parent, Member children);
	
	public List<Member> getFollowers(int memberId);
	
	public List<Member> getFollowedParent(int memberId);
	
	public boolean isFollowed(String parentId, String followerId);
}