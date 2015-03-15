<div class="container">
	<div class="row">
		<div class="col-sm-12">
			<img src="${assetPath(src: 'banner.png')}">
		</div>
	</div>
	
	<div class="row"> <!-- Begin Nested Rows -->
		<div class="col-sm-5 col-sm-offset-1">
			<h3>${welcomeMessage}</h3>
		</div>
		<div class="col-sm-6"> <!-- Begin Phone Entry -->
			<g:textField name="phone" class="form-control" placeholder="Enter your cell number to check in" value="${customerInstance?.phone}" />
			<div class ="row">
				<h3></h3>
			</div>
			<div class ="row"> <!-- Begin first keypad row -->
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="1" onClick="padkey(this.value)" />
				</div>
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="2" onClick="padkey(this.value)" />
				</div>
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="3" onClick="padkey(this.value)" />
				</div>								
			</div> <!-- End first keypad row -->
			<div class ="row">
				<h3></h3>
			</div>
			<div class ="row"> <!-- Begin second keypad row -->
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="4" onClick="padkey(this.value)" />
				</div>
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="5" onClick="padkey(this.value)" />
				</div>
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="6" onClick="padkey(this.value)" />
				</div>								
			</div> <!-- End second keypad row -->
			<div class ="row">
				<h3></h3>
			</div>
			<div class ="row">  <!-- Begin third keypad row -->
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="7" onClick="padkey(this.value)" />
				</div>
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="8" onClick="padkey(this.value)" />
				</div>
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="9" onClick="padkey(this.value)" />
				</div>								
			</div>	<!-- End third keypad row -->
			<div class ="row">
				<h3></h3>
			</div>
			<div class ="row"> <!-- Begin fourth and final keypad row -->
				<div class = "col-sm-4">
					<g:link class="btn btn-danger btn-lg btn-block" action="checkin">Del</g:link>
				</div>
				<div class = "col-sm-4">
					<input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="0" onClick="padkey(this.value)" />
				</div>
				<div class = "col-sm-4">
					<g:submitButton class="btn btn-success btn-lg btn-block" name="pad" value="Go" />
				</div>								
			</div>	<!-- End fourth and final keypad row -->							
		</div> <!-- End Phone Entry -->		
	</div> <!-- End nested rows -->
</div> <!-- End Container -->

<!-- pad button script -->
<script> function padkey(num) {
	var txt=document.getElementById("phone").value;
	txt=txt + num;
	document.getElementById("phone").value=txt;
	}
</script>