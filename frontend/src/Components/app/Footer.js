import "../../css/footer.css"

function Footer() {
	return (
		<footer className="py-4 bg-dark text-light footer">
          <div className="container text-center">
            <ul className="nav justify-content-center mb-3">
              <li className="nav-item">
                <a className="nav-link text-light" href="/">Top</a>
              </li>
            </ul>

            <p>
              <small>Copyright &copy;NaYeon Kwon</small>
            </p>
          </div>
        </footer>
	);
}

export default Footer;