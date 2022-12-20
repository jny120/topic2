package evaluation.model;

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
import project.model.Project;

@Entity
@Table(name = "Evaluation")
public class Evaluation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ev_ID")
	private Integer evID;
	
	@ManyToOne
	@JoinColumn(name = "fk_evaluation_pjID")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name = "fk_evaluation_memberID")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "fk_evaluation_serverID")
	private Member server;
	
	@Column(name = "ev_DealPrice")
	private Integer evDealPrice;
	
	@Column(name = "ev_CompletionDate")
	private Date evCompletionDate;
	
	@Column(name = "ev_ClientEV")
	private Integer evClientEV;
	
	@Column(name = "ev_CLientComment")
	private String evCLientComment;
	
	public Evaluation() {
	}

	public Integer getEvID() {
		return evID;
	}

	public void setEvID(Integer evID) {
		this.evID = evID;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getServer() {
		return server;
	}

	public void setServer(Member server) {
		this.server = server;
	}

	public Integer getEvDealPrice() {
		return evDealPrice;
	}

	public void setEvDealPrice(Integer evDealPrice) {
		this.evDealPrice = evDealPrice;
	}

	public Date getEvCompletionDate() {
		return evCompletionDate;
	}

	public void setEvCompletionDate(Date evCompletionDate) {
		this.evCompletionDate = evCompletionDate;
	}

	public Integer getEvClientEV() {
		return evClientEV;
	}

	public void setEvClientEV(Integer evClientEV) {
		this.evClientEV = evClientEV;
	}

	public String getEvCLientComment() {
		return evCLientComment;
	}

	public void setEvCLientComment(String evCLientComment) {
		this.evCLientComment = evCLientComment;
	}

	@Override
	public String toString() {
		return "Evaluation [evID=" + evID + ", project=" + project + ", member=" + member + ", server=" + server
				+ ", evDealPrice=" + evDealPrice + ", evCompletionDate=" + evCompletionDate + ", evClientEV="
				+ evClientEV + ", evCLientComment=" + evCLientComment + "]";
	}

}
