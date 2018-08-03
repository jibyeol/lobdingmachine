
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Start Bootstrap</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${context }/admin/product">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">상품 관리</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${context }/admin/repository">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">재고관리</span>
          </a>
        </li>
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${context }/admin/statistics">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">통계</span>
          </a>
        </li>
        <%-- <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${context }/admin/image">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">이미지 업로드</span>
          </a>
        </li> --%>
      </ul>
      <%-- <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link" href="${context }/logout">
            <i class="fa fa-fw fa-sign-out"></i>로그아웃</a>
          <a class="nav-link" href="${context }/user/login">
            <i class="fa fa-fw fa-sign-out"></i>로그인</a>
        </li>
      </ul> --%>
    </div>
  </nav>