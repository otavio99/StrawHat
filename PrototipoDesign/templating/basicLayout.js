const menu = document.getElementById("menuStrawHat")
const render= hyperHTML

hyperHTML.bind(menu)`
	<a class="navbar-brand" href="#">
		StrawHat
	</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse justify-content-end" id="navbarNav">
		<ul class="navbar-nav text-center">
			<li class="nav-item active">
				<a class="nav-link" href="index.html">Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Contato</a>
			</li>
		</ul>
	</div>
`

const footer = document.getElementById("footerStrawHat")

hyperHTML.bind(footer)`
	<div class="footer-right">
		<a href="#"><i class="fa fa-facebook"></i></a>
		<a href="#"><i class="fa fa-twitter"></i></a>
		<a href="#"><i class="fa fa-linkedin"></i></a>
		<a href="#"><i class="fa fa-github"></i></a>
	</div>

	<div class="footer-left">
		<p>StrawHat © 2020</p>
	</div>
`
