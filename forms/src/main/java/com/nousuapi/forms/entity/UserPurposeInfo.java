package com.nousuapi.forms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.nousuapi.forms.enums.IlGroup;
import com.nousuapi.forms.enums.Location;
import com.nousuapi.forms.enums.OnsiteDay;
import com.nousuapi.forms.enums.UserRole;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userpurposeinfo")
public class UserPurposeInfo {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private long id;
	
	//where user is located during tournament
	@NotNull
	@Enumerated(EnumType.STRING)
	private Location location;
	
	@Column(name = "person_name")
	private String personName;
	
	@Column(name = "team_leader")
	private String teamLeader;
	
	@Column(name = "leader_team")
	private String leaderTeam;
	
	@Column(name = "leader_full_name")
	private String leader_full_name;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "il_group")
	private IlGroup ilGroup;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role")
	private UserRole userRole;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "week_day")
	private OnsiteDay weekDay;
		
	//what time person will be onsite
	@Column(name = "start_time")
	private String startTime;
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "person_in_charge")
	private String personInCharge;
}
