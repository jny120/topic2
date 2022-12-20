package member.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import project.model.Project;

import evaluation.model.Evaluation;

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberPk")
	private Integer memberPk;

	@Column(name = "memberId")
	private String memberId;

	@Column(name = "name")
	private String name;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "userType")
	private String userType;
	
	@Column(name = "registerTime")
	private Timestamp registerTime;
	
	@Column(name = "memberImage")
	private Blob memberImage;
	
	@Column(name = "lastLogin")
	private Timestamp lastLogin;
	
	@Column(name = "verification")
	private Integer verification;
	
	@Column(name = "permission")
	private Integer permission;
	
	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<Project> projects = new ArrayList<>();
	
	@OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
	private List<Evaluation> evaluationMember = new ArrayList<>();
	
	@OneToMany(mappedBy = "server",cascade = CascadeType.ALL)
	private List<Evaluation> evaluationServer = new ArrayList<>();

	public Member() {
	}

	public Integer getMemberPk() {
		return memberPk;
	}

	public void setMemberPk(Integer memberPk) {
		this.memberPk = memberPk;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}



	public Timestamp getRegisterTime() {
		return registerTime;
	}



	public void setRegisterTime() {
		Date date = new Date();
		Timestamp ts = new Timestamp( date.getTime() ); 
		this.registerTime = ts;
	}



	public Blob getMemberImage() {
		return memberImage;
	}



	public void setMemberImage(Blob memberImage) {
		this.memberImage = memberImage;
	}



	public Timestamp getLastLogin() {
		return lastLogin;
	}



	public void setLastLogin(Timestamp time) {
		this.lastLogin = time;
	}



	public Integer getVerification() {
		return verification;
	}



	public void setVerification(Integer verification) {
		this.verification = verification;
	}



	public Integer getPermission() {
		return permission;
	}



	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Evaluation> getEvaluationMember() {
		return evaluationMember;
	}

	public void setEvaluationMember(List<Evaluation> evaluationMember) {
		this.evaluationMember = evaluationMember;
	}

	public List<Evaluation> getEvaluationServer() {
		return evaluationServer;
	}

	public void setEvaluationServer(List<Evaluation> evaluationServer) {
		this.evaluationServer = evaluationServer;
	}

	@Override
	public String toString() {
		return "Member [memberPk=" + memberPk + ", memberId=" + memberId + ", name=" + name + ", password=" + password
				+ ", location=" + location + ", email=" + email + ", phone=" + phone + ", userType=" + userType
				+ ", registerTime=" + registerTime + ", memberImage=" + memberImage + ", lastLogin=" + lastLogin
				+ ", verification=" + verification + ", permission=" + permission + ", projects=" + projects
				+ ", evaluationMember=" + evaluationMember + ", evaluationServer=" + evaluationServer + "]";
	}

	
}