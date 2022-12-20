package project.model;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import member.model.Member;

@Entity
@Table(name = "Project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pj_ID")
	private Integer pjID;
	
	@Column(name = "pj_Class")
	private String pjClass;
	
	@Column(name = "fieldName")
	private String fieldName;
	
	@Column(name = "pj_Name")
	private String pjName;
	
	@ManyToOne
	@JoinColumn(name = "fk_project_memberID")
	private Member member;
	
	@Column(name = "pj_Instruction")
	private String pjInstruction;
	
	@Column(name = "pj_ServerLocation")
	private String pjServerLocation;
	
	@Column(name = "pj_Price")
	private int pjPrice;
	
	@Column(name = "pj_ExCompletionDate")
	private Date pjExCompletionDate;
	
	@Column(name = "pj_ExecutionTime")
	private String pjExecutionTime;
	
	@Column(name = "pj_UploadDate")
	private Date pjUploadDate;
	
	@Column(name = "pj_LastUpdate")
	private Date pjLastUpdate;
	
	@Column(name = "pj_Image")
	private Blob pjImage;
	
	@Column(name = "pj_Status")
	private String pjStatus;

	public Project() {
	}

	
	public int getPjID() {
		return pjID;
	}
	
	public void setPjID(Integer pjID) {
		this.pjID = pjID;
	}

	public String getPjClass() {
		return pjClass;
	}

	public void setPjClass(String pjClass) {
		this.pjClass = pjClass;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getPjName() {
		return pjName;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getPjInstruction() {
		return pjInstruction;
	}

	public void setPjInstruction(String pjInstruction) {
		this.pjInstruction = pjInstruction;
	}

	public String getPjServerLocation() {
		return pjServerLocation;
	}

	public void setPjServerLocation(String pjServerLocation) {
		this.pjServerLocation = pjServerLocation;
	}

	public int getPjPrice() {
		return pjPrice;
	}

	public void setPjPrice(int pjPrice) {
		this.pjPrice = pjPrice;
	}

	public Date getPjExCompletionDate() {
		return pjExCompletionDate;
	}

	public void setPjExCompletionDate(Date pjExCompletionDate) {
		Timestamp ts = new Timestamp(pjExCompletionDate.getTime());
		this.pjExCompletionDate = ts;
	}

	public String getPjExecutionTime() {
		return pjExecutionTime;
	}

	public void setPjExecutionTime(String pjExecutionTime) {
		this.pjExecutionTime = pjExecutionTime;
	}

	public Date getPjUploadDate() {
		return pjUploadDate;
	}

	public void setPjUploadDate(Date pjUploadDate) {
		Timestamp ts = new Timestamp(pjUploadDate.getTime());
		this.pjUploadDate = ts;
	}

	public Date getPjLastUpdate() {
		return pjLastUpdate;
	}

	public void setPjLastUpdate(Date pjLastUpdate) {
		Timestamp ts = new Timestamp(pjLastUpdate.getTime());
		this.pjLastUpdate = ts;
	}

	public Blob getPjImage() {
		return pjImage;
	}

	public void setPjImage(Blob pjImage) {
		this.pjImage = pjImage;
	}

	public String getPjStatus() {
		return pjStatus;
	}

	public void setPjStatus(String pjStatus) {
		this.pjStatus = pjStatus;
	}

	@Override
	public String toString() {
		return "Project [pjID=" + pjID + ", pjClass=" + pjClass + ", fieldName=" + fieldName + ", pjName=" + pjName
				+ ", member=" + member + ", pjInstruction=" + pjInstruction + ", pjServerLocation=" + pjServerLocation
				+ ", pjPrice=" + pjPrice + ", pjExCompletionDate=" + pjExCompletionDate + ", pjExecutionTime="
				+ pjExecutionTime + ", pjUploadDate=" + pjUploadDate + ", pjLastUpdate=" + pjLastUpdate + ", pjImage="
				+ pjImage + ", pjStatus=" + pjStatus + "]";
	}

}
