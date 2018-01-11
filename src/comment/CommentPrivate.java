package comment;

import java.math.BigInteger;

import param.Params;

public class CommentPrivate {
	/*
	 * 需要实现序列化
	 */
	
	private Params params;
	private CommentPublic commentPublic;
	private BigInteger randomnes;
	private BigInteger serialNumber;
	private void makeComment() {
		
	}
	
	public CommentPrivate(Params params, String comment) {
		this.params = params;
		this.commentPublic = new CommentPublic(params, comment);
	}
	
	public CommentPublic getCommentPublic() {
		return this.commentPublic;
	}
	
	public BigInteger getSerialNumber() {
		return this.serialNumber;
	}
	
	public BigInteger getRandomness() {
		return this.randomnes;
	}
}
