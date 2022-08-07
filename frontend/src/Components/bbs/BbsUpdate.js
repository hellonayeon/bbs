import axios from "axios";
import { useLocation, useNavigate } from "react-router-dom";
import { useContext, useState } from "react";
import { AuthContext } from "../context/AuthProvider";
import { HttpHeadersContext } from "../context/HttpHeadersProvider";

function BbsUpdate() {

	const { headers, setHeaders } = useContext(HttpHeadersContext);
	const { auth, setAuth } = useContext(AuthContext);

	const navigate = useNavigate();

	const location = useLocation();
	const { bbs } = location.state;
	
	const [title, setTitle] = useState(bbs.title);
	const [content, setContent] = useState(bbs.content);

	const changeTitle = (event) => {
		setTitle(event.target.value);
	}

	const changeContent = (event) => {
		setContent(event.target.value);
	}

	const updateBbs = async () => {

		const req = {
			id: auth, 
			title: title, 
			content: content
		}

		await axios.patch(`http://localhost:3000/bbs/${bbs.seq}`, req, {headers: headers})
		.then((resp) => {
			console.log("[BbsUpdate.js] updateBbs() success :D");
			console.log(resp.data);

			if (resp.data.updatedRecordCount == 1) {
				alert("게시글을 성공적으로 수정했습니다 :D");
				navigate(`/bbsdetail/${bbs.seq}`); // 글 상세로 이동
			}

		})
		.catch((err) => {
			console.log("[BbsUpdate.js] updateBbs() error :<");
			console.log(err);
		});

	}


	return (
		<div>
			<table className="table">
				<tbody>
					<tr>
						<th className="table-primary">작성자</th>
						<td>
							<input type="text" className="form-control"  value={bbs.id} size="50px" readOnly />
						</td>
					</tr>

					<tr>
						<th className="table-primary">제목</th>
						<td>
							<input type="text" className="form-control" value={title} onChange={changeTitle} size="50px" />
						</td>
					</tr>

					<tr>
						<th className="table-primary">내용</th>
						<td>
							<textarea className="form-control" value={content} onChange={changeContent} rows="10" ></textarea>
						</td>
					</tr>
				</tbody>
			</table>

			<div className="my-3 d-flex justify-content-center">
				<button className="btn btn-dark" onClick={updateBbs}><i className="fas fa-pen"></i> 수정하기</button>
			</div>
		</div>
	);

}

export default BbsUpdate;