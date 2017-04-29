<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>





<form align=center method="post" class="form-inline " action="search">
	<div class="form-group form-group-lg has-feedback">
		<img src="./static/image/bigdata.jpg" style="width: 50%%" alt="Avatar">
		<label class="sr-only" for="search">Search</label>

		<c:choose>
			<c:when test="${ key != null }">
				<input type="text" class="form-control" name="q" id="search"
					value="${ key }" placeholder="Search">
				<span
					class="glyphicons glyphicons-xl glyphicons-group form-control-feedback"></span>

			</c:when>
			<c:otherwise>
				<input type="text" class="form-control" name="q" id="search"
					placeholder="Search">
				<span
					class="glyphicons glyphicons-xl glyphicons-group form-control-feedback"></span>
			</c:otherwise>
		</c:choose>


		<button type="submit" class="btn btn-lg btn-success">
			<span class="glyphicons glyphicons-search" aria-hidden="true"></span>Search
		</button>
	</div>

</form>

<c:if test="${ imdbBean.response }">
	<label>IMDB Rating</label>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<th><strong>Movie Name</strong></th>
			<th><strong>Year</strong></th>
			<th><strong>Rating</strong></th>
		</tr>
		<tr>
			<td>${ imdbBean.title }</td>
			<td>${ imdbBean.year }</td>
			<td>${ imdbBean.rating }</td>
		</tr>
	</table>
</c:if>


<c:choose>
	<c:when test="${ showTable }">
		<label>Total Count = ${ sentimentScoreBeanList.size() }</label>
		<c:choose>
			<c:when test="${ sentimentScoreCountPercentList.size() > 0 }">
				<table id="simple-table"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><strong>Score</strong></th>
							<th><strong>Count</strong></th>
							<th><strong>% Count</strong></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ sentimentScoreCountPercentList }"
							var="sentimentScoreCountPercent">
							<tr>
								<td>${ sentimentScoreCountPercent.score  }</td>
								<td>${ sentimentScoreCountPercent.count }</td>
								<td>${ sentimentScoreCountPercent.percent }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>

		<c:choose>
			<c:when test="${ sentimentScoreBeanList.size() > 0 }">
				<table id="simple-table"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th><strong>Tweet Text</strong></th>
							<th><strong>Score</strong></th>
							<th><strong>Analysis</strong></th>
							<th><strong>Time</strong></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ sentimentScoreBeanList }"
							var="sentimentScoreBean">
							<tr>
								<td>${ sentimentScoreBean.tweetText  }</td>
								<td>${ sentimentScoreBean.score }</td>
								<td>${ sentimentScoreBean.grade }</td>
								<td>${ sentimentScoreBean.tweetTime }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<div style="text-align: center;">
					<h2>There is no data present for this search criteria.</h2>
				</div>

			</c:otherwise>
		</c:choose>
	</c:when>
</c:choose>