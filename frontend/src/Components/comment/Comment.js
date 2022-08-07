import axios from "axios";
import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom"
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";


/* 댓글 컴포넌트 */
function Comment(props) {
	const {auth, setAuth} = useContext(AuthContext);
	const {headers, setHeaders} = useContext(HttpHeadersContext);
	const comment = props.obj;

	const navigate = useNavigate();

	const [show, setShow] = useState(false);

	const [content, setContent] = useState(comment.content);
	const changeContent = (event) => {
		setContent(event.target.value);
	};

	/* 댓글 수정 */
	const updateComment = async () => {

		const req = {
			content: content
		};

		await axios.patch(`http://localhost:3000/comment/${comment.seq}`, req, {headers: headers})
		.then((resp) => {
			
			console.log("[Comment.js] updateComment() success :D");
			console.log(resp.data);

			alert("댓글을 성공적으로 수정했습니다 !");
			navigate(0);

		}).catch((err) => {

			console.log("[Comment.js] updateComment() error :<");
			console.log(err);

			alert(err.response.data);

		});


		updateToggle();
	}

	/* 댓글 삭제 */
	const deleteComment = async () => {
		await axios.delete(`http://localhost:3000/comment/${comment.seq}`)
			.then((resp) => {
				console.log("[BbsComment.js] deleteComment() success :D");
				console.log(resp.data);

				if (resp.data.deletedRecordCount == 1) {
					alert("답글을 성공적으로 삭제했습니다 :D");
					navigate(0);
				}
			}).catch((err) => {
				console.log("[BbsComment.js] deleteComment() error :<");
				console.log(err);
			});
	}

	function updateToggle() { 
		setShow(show => !show) 
	}

	// 삭제되지 않은 댓글의 경우
	if (comment.del == 0) {
		return (
			<>
				{/* 상단 영역 (프로필 이미지, 댓글 작성자, 댓글 작성시간) */}
				<div className="my-1 d-flex justify-content-center">
					<div className="col-1">
						<img src="/images/profile-placeholder.png" alt="프로필 이미지"
							className="profile-img" />
					</div>
					<div className="col-5">
						<div className="row">
							<span className="comment-id">{comment.id}</span>
						</div>
						<div className="row">
							<span>{comment.createdAt}</span>
						</div>
					</div>

					<div className="col-4 d-flex justify-content-end">
					{
						/* 자신이 작성한 댓글인 경우에만 수정 삭제 가능 */
						(localStorage.getItem("id") == comment.id) ?
							<>
								<button className="btn btn-outline-secondary" onClick={updateToggle}><i className="fas fa-edit"></i> 수정</button> &nbsp; 
								<button className="btn btn-outline-danger" onClick={deleteComment}><i className="fas fa-trash-alt"></i> 삭제</button>
							
							</>
							:
							null
					}
					</div>
				</div>

				{
					/* 댓글 수정하는 경우 */
					show ?
						<>
							{/* 하단 영역 (댓글 내용 + 댓글 내용 편집 창) */}
							<div className="my-3 d-flex justify-content-center">
								<textarea className="col-10" rows="5" value={content} onChange={changeContent}></textarea>
							</div>
							<div className="my-1 d-flex justify-content-center">
								<button className="btn btn-dark" onClick={updateComment}><i className="fas fa-edit"></i>  수정 완료</button>
							</div>
						</>
					:
						<>
							{/* 하단 영역 (댓글 내용) */}
							<div className="my-3 d-flex justify-content-center">
								<div className="col-10 comment">{content}</div>
							</div>
						</>
				}


			</>
		);
	}

	// 삭제된 댓글의 경우
	else {
		return (
			<>
				<div className="my-5 d-flex justify-content-center">
					<div className="comment">
						<span className="del-span">⚠️ 작성자에 의해 삭제된 댓글입니다.</span>
					</div>
				</div>
			</>
		);
	}
}

export default Comment;