<%@ include file="includes/header.jsp"%>
<FORM method="post" action="ApplyForJob.php?positionID='.$positionID.'">
	<div class="outsider">
		<h1 class="header2">
			<strong><span class="glyphicon glyphicon-file"></span>&nbspApplication</strong>
		</h1>

		<div class="grey">
			<h1>
				<br>
			</h1>
			<div class="container-fluid">
				<div class="form-check form-check-inline">
					<div class="form-check">
						<label><strong>First Name*&nbsp&nbsp</strong></label> <input
							type="text" id="first_name" name="first_name">

					</div>

					<div class="form-check">
						<label><strong>Last Name*&nbsp&nbsp</strong></label> <input
							type="text" id="last_name" name="last_name">

					</div>
				</div>
				<div class="row">
					<label><strong>Contact Email*&nbsp&nbsp</strong></label> <input
						type="email" id="email" name="email">
				</div>
				<div class="row">
					<label><strong>Phone*&nbsp&nbsp</strong></label> <input type="text"
						id="last_name" name="phone">
				</div>
				<div class="row">
					<label><strong>Address*&nbsp&nbsp</strong></label> <input
						type="text" id="address" name="address">
				</div>

				<div class="form-check form-check-inline">
					<div class="form-check">
						<label><strong>City*&nbsp&nbsp</strong></label> <input type="text"
							id="city" name="city">

					</div>

					<div class="form-check">
						<label><strong>State*&nbsp&nbsp</strong></label> <input
							type="text" id="state" name="state">
					</div>
					<div class="form-check">
						<label><strong>Zip Code*&nbsp&nbsp</strong></label> <input
							type="text" id="zipcode" name="zipcode">


					</div>
				</div>
				<div class="row">
					<label><strong>Country*&nbsp&nbsp</strong></label> <input
						type="text" id="country" name="country">
				</div>


			</div>
		</div>

	</div>


	<div class="outsider">
		<h3>Reference*</h3>
		<div class="grey">

			<div class="container-fluid">
				<br>
				<div class="row">
					<h4>Resume&nbsp&nbsp</h4>


					<input type="submit" value="Upload" name="submit">

				</div>


				<div class="row">
					<label><strong>Date Available&nbsp&nbsp</strong></label> <input
						type="text" id="date" name="date">
				</div>
				<div class="row">
					<label><strong>Website, Blog or
							Portfolio&nbsp&nbsp</strong></label> <input type="text" id="website"
						name="website">
				</div>
			</div>


		</div>


		<p align="center">
			<input type="submit" name="submit" value="Submit" />
		</p>
		<input type="hidden" name="submitted" value="TRUE" /> <input
			type="hidden" name="id" value="\' . $id . \'" />
</FORM>

<%@ include file="includes/footer.jsp"%>