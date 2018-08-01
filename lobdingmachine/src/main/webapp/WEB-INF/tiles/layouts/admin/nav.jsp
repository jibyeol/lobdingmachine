
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Start Bootstrap</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
      <security:authorize access="hasRole('ROLE_ADMIN')">
      <!-- 관리자 메뉴 -->
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${context }/admin/menu">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">메뉴 관리</span>
          </a>
        </li>
      </security:authorize>
      <security:authorize access="hasRole('ROLE_GENERAL')">
      <!-- 고객 메뉴 -->
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="${context }/customer/menu">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">메뉴보기</span>
          </a>
        </li>
      </security:authorize>
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
        <security:authorize access="isAuthenticated()">
          <a class="nav-link" href="${context }/logout">
            <i class="fa fa-fw fa-sign-out"></i>로그아웃</a>
        </security:authorize>
        <security:authorize access="isAnonymous()">
          <a class="nav-link" href="${context }/user/login">
            <i class="fa fa-fw fa-sign-out"></i>로그인</a>
        </security:authorize>
        </li>
      </ul>
    </div>
  </nav>