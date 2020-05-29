package com.els.base.member.service.member.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.els.base.member.dao.member.MemberFollowerMapper;
import com.els.base.member.entity.member.Member;
import com.els.base.member.entity.member.MemberFollower;
import com.els.base.member.entity.member.MemberFollowerExample;
import com.els.base.member.service.member.MemberFollowerService;
import com.els.base.member.service.member.MemberService;

@Service("memberFollowerService")
public class MemberFollowerServiceImpl implements MemberFollowerService {
    
	@Resource
    protected MemberFollowerMapper memberFollowerMapper;
	
	@Resource
	protected MemberService memberService;

	@CacheEvict(value={"MemberFollowerService_parent", "MemberFollowerService_follows"}, key="#memberId")
	@Override
	public void follow(Member parent, Member children) {
		
		if (this.isFollowed(parent.getId(), children.getId())) {
			return;
		}
		
		MemberFollower follow = new MemberFollower();
		follow.setParentId(Integer.valueOf(parent.getId()));
		follow.setParentName(parent.getName());
		follow.setParentHeadImgUrl(parent.getHeadImgUrl());
		follow.setFollowerId(Integer.valueOf(children.getId()));
		follow.setFollowerName(children.getName());
		follow.setFollowerHeadImgUrl(children.getHeadImgUrl());
		
		this.memberFollowerMapper.insertSelective(follow);
	}

	@CacheEvict(value={"MemberFollowerService_parent", "MemberFollowerService_follows"}, key="#memberId")
	@Override
	public void unFollow(Member parent, Member children) {
		MemberFollowerExample example = new MemberFollowerExample();
		example.createCriteria()
		       .andParentIdEqualTo(Integer.valueOf(parent.getId()))
		       .andFollowerIdEqualTo(Integer.valueOf(children.getId()));
		
		this.memberFollowerMapper.deleteByExample(example);
		
	}

	@Cacheable(value="MemberFollowerService_follows", key="#memberId")
	@Override
	public List<Member> getFollowers(int memberId) {
		MemberFollowerExample example = new MemberFollowerExample();
		example.createCriteria().andParentIdEqualTo(memberId);
		
		List<MemberFollower> followers = this.memberFollowerMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(followers)) {
			return null;
		}
		
		List<Member> members = new ArrayList<>(followers.size());
		
		for(int i=0; i<followers.size(); i++){
			members.add(this.memberService.queryObjById(followers.get(i).getFollowerId().toString()));
		}
		
		return members;
	}

	@Cacheable(value="MemberFollowerService_parent", key="#memberId")
	@Override
	public List<Member> getFollowedParent(int memberId) {
		MemberFollowerExample example = new MemberFollowerExample();
		example.createCriteria().andFollowerIdEqualTo(memberId);
		
		List<MemberFollower> followedParents = this.memberFollowerMapper.selectByExample(example);
		if (CollectionUtils.isEmpty(followedParents)) {
			return null;
		}
		
        List<Member> members = new ArrayList<>(followedParents.size());
		
		for(int i=0; i<followedParents.size(); i++){
			members.add(this.memberService.queryObjById(followedParents.get(i).getParentId().toString()));
		}
		
		return members;
	}

	@Override
	public boolean isFollowed(String parentId, String followerId) {
		MemberFollowerExample example = new MemberFollowerExample();
		example.createCriteria()
		       .andParentIdEqualTo(Integer.valueOf(parentId))
		       .andFollowerIdEqualTo(Integer.valueOf(followerId));
		int count = this.memberFollowerMapper.countByExample(example);
		
		return count > 0;
	}

    
}