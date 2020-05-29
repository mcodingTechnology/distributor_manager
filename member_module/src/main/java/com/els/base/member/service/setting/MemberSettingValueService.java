package com.els.base.member.service.setting;

import java.util.List;

import com.els.base.core.service.BaseService;
import com.els.base.member.entity.setting.MemberSettingValue;
import com.els.base.member.entity.setting.MemberSettingValueExample;

public interface MemberSettingValueService extends BaseService<MemberSettingValue, MemberSettingValueExample, Integer> {
	
	public void changeOneMemberSettingValue(int memberId, String code, String value, Integer codeModuleTypeSns, int storeId);
	
//	public void changeManyMemberSettingValue(List<MemberSettingValue> valueList, Integer moduleType, int storeId);

	public List<MemberSettingValue> queryObjByMemberId(int memberId, int storeId, int moduleType);
	
	public MemberSettingValue queryObjByMemberId(String settingKeyCode, int memberId, int storeId, int moduleType);
}