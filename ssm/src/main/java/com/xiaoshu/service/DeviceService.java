package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.TypeMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.Type;
import com.xiaoshu.entity.TypeVo;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class DeviceService {

	@Autowired
	DeviceMapper deviceMapper;
	
	@Autowired
	TypeMapper typeMapper;

	public PageInfo<Device> finddevicePage(Device device, Integer pageNum, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, pageSize);
		List<Device> userList = deviceMapper.findALL(device);
		PageInfo<Device> pageInfo = new PageInfo<Device>(userList);
		return pageInfo;
	}

	public Device existdeviceName(String deviceName) {
		// TODO Auto-generated method stub
		List<Device> userList=deviceMapper.findDeviceBydeviceName(deviceName);
		return userList.isEmpty()?null:userList.get(0);
	}

	public void addDevice(Device device) {
		// TODO Auto-generated method stub
		deviceMapper.insert(device);
	}

	public void deleteDevice(int parseInt) {
		// TODO Auto-generated method stub
		deviceMapper.deleteByPrimaryKey(parseInt);
	}

	public void updateDevice(Device device) {
		// TODO Auto-generated method stub
		deviceMapper.updateByPrimaryKey(device);
	}

	public List<Type> findRole() {
		// TODO Auto-generated method stub
		return typeMapper.selectAll();
	}

	public List<TypeVo> findTypeVo() {
		// TODO Auto-generated method stub
		return deviceMapper.findTypeVo();
	}
}