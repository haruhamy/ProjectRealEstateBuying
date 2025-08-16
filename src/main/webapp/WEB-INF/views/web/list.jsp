<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sản phẩm</title>
</head>

<body>
<div class="page-wrapper">
    <%--<header>--%>
    <%--<!-- MENU  -->--%>
    <%--<div class="p-4">--%>
    <%--<div class="row navbar">--%>
    <%--<div class="col-12 col-md-3">--%>
    <%--<div class="logo">--%>
    <%--<a href="/trang-chu">--%>
    <%--<img src="https://bizweb.dktcdn.net/100/328/362/themes/894751/assets/logo.png?1676257083798"--%>
    <%--alt="">--%>
    <%--</a>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-12 col-md-6">--%>
    <%--<div class="item-menu">--%>
    <%--<div class="nav nav1">--%>
    <%--<div class="nav-item p-2"><a class="nav-item-link" href="/trang-chu"><span>Trang--%>
    <%--chủ</span></a></div>--%>
    <%--<div class="nav-item p-2"><a class="nav-item-link" href="/gioi-thieu"><span>Giới--%>
    <%--thiệu</span></a></div>--%>
    <%--<div class="nav-item p-2"><a class="nav-item-link" href=""><span--%>
    <%--style="color: var(--primary-color);">Sản phẩm</span></a></div>--%>
    <%--<div class="nav-item p-2"><a class="nav-item-link" href="/tin-tuc"><span>Tin--%>
    <%--tức</span></a>--%>
    <%--</div>--%>
    <%--<div class="nav-item p-2"><a href='<c:url value='/lien-he'/>'><span>Liên hệ--%>
    <%--</span></a>--%>
    <%--</div>--%>

    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<div class="col-12 col-md-3">--%>
    <%--<button class="btn btn-primary px-4">--%>
    <%--Liên hệ tư vấn--%>
    <%--</button>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</header>--%>
    <!-- INTRO  -->
    <div class="intro text-center">
        <div class="title-page">Tất cả dự án</div>
        <div class="row">
            <div class="col-xs-12 a-left">
                <ul class="desc-intro">
                    <li class="home">
                        <a href="./ViewHome.html"><span style="color:#fff">Trang chủ</span></a>
                        <span class="mx-1" style="color:#fff"> / </span>
                    </li>
                    <li class="intro-item"><span>Tất cả sản phẩm</span></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- SEARCH  -->
    <div class="search">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-3 search-item">
                    <p class="search-text">Chọn quận</p>
                    <select class="search-option" name="city" id="city-select">
                        <option value="">-- Chọn quận --</option>
                        <option value="quan1">Quận 1</option>
                        <option value="quan3">Quận 3</option>
                        <option value="quan5">Quận 5</option>
                        <option value="quan7">Quận 7</option>
                        <option value="thu-duc">Thành phố Thủ Đức</option>
                    </select>
                </div>

                <div class="col-12 col-md-3 search-item">
                    <p class="search-text">Đường</p>
                    <%-- <select class="search-option" name="district" id="district-select">
                        <option value="">-- Chọn quận/huyện --</option>
                    </select> --%>
                    <select class="search-option" name="district" id="district-select">
                        <option value="">-- Chọn đường --</option>
                    </select>
                </div>

                <div class="col-12 col-md-3 search-item">
                    <p class="search-text">Chọn loại bất động sản</p>
                    <select class="search-option" name="type" id="type-select">
                        <option value="">-- Chọn loại bất động sản --</option>
                        <option value="can-ho">Căn hộ</option>
                        <option value="shophouse">Shophouse</option>
                        <option value="biet-thu">Biệt thự</option>
                        <option value="dat-nen">Đất nền</option>
                        <option value="office">Văn phòng</option>
                        <option value="nha-pho">Nhà phố</option>
                    </select>
                </div>

                <div class="col-12 col-md-3 search-btn d-flex align-items-end">
                    <button class="search-btn-text">
                        <i class="fa-solid fa-magnifying-glass search-btn-icon"></i>
                        <span>Tìm kiếm nhanh</span>
                    </button>
                    <button id="reset-btn" class="search-btn-text">
                        <i class="fa-solid fa-rotate-right search-btn-icon"></i>
                        <span>Làm mới</span>
                    </button>
                </div>
            </div>
        </div>

    </div>
    <div id="search-result" class="container mt-4"></div>

    <!-- CONTENT  -->
    <div class="product mt-5" id="original-product-list">
        <div class="container">
            <div class="row">
                <!-- Nội dung sẽ được JS render từ file JSON -->
            </div>
        </div>
    </div>


    <%--    Xử lí phần Tìm kiếm--%>
    <script>

        const streetsByDistrict = {
            "quan1": [
                { value: "le-loi", text: "Lê Lợi" },
                { value: "nguyen-hue", text: "Nguyễn Huệ" },
                { value: "dong-khoi", text: "Đồng Khởi" },
                { value: "ton-duc-thang", text: "Tôn Đức Thắng" }
            ],
            "quan3": [
                { value: "nguyen-dinh-chieu", text: "Nguyễn Đình Chiểu" },
                { value: "ly-chinh-thang", text: "Lý Chính Thắng" },
                { value: "cach-mang-thang-8", text: "Cách Mạng Tháng 8" }
            ],
            "quan5": [
                { value: "tran-hung-dao", text: "Trần Hưng Đạo" },
                { value: "nguyen-trai", text: "Nguyễn Trãi" },
                { value: "hung-vuong", text: "Hùng Vương" }
            ],
            "quan7": [
                { value: "nguyen-van-linh", text: "Nguyễn Văn Linh" },
                { value: "phu-my-hung", text: "Phú Mỹ Hưng" },
                { value: "tan-my", text: "Tân Mỹ" }
            ],
            "thu-duc": [
                { value: "kha-van-can", text: "Kha Vạn Cân" },
                { value: "vo-van-ngan", text: "Võ Văn Ngân" },
                { value: "to-vinh-dien", text: "Tô Vĩnh Diện" }
            ]
        };

        const citySelect = document.getElementById("city-select");
        const districtSelect = document.getElementById("district-select");

        citySelect.addEventListener("change", function () {
            const selectedCity = citySelect.value;
            const districts = streetsByDistrict[selectedCity] || [];

            districtSelect.innerHTML = '<option value="">-- Chọn đường --</option>';

            districts.forEach(function (district) {
                const option = document.createElement("option");
                option.value = district.value; // ví dụ "quan3"
                option.textContent = district.text; // ví dụ "Quận 3"
                districtSelect.appendChild(option);
            });
        });


    </script>

    <%--    Test--%>


    <script>

        function searchMatchedProperty(city, district, type) {
            const matched = propertySamples.filter(p =>
                (!city || p.city === city) &&
                (!district || p.district === district) &&
                (!type || p.type === type)
            );
            return matched;
        }


        let propertySamples = [];

        fetch('/data.json')
            .then(response => response.json())
            .then(data => {
                propertySamples = data;
            })
            .catch(error => {
                console.error("Không thể tải dữ liệu bất động sản:", error);
            });



        document.querySelector('.search-btn-text').addEventListener('click', function (e) {
            e.preventDefault();

            const city = document.getElementById("city-select").value;
            const district = document.getElementById("district-select").value;
            const type = document.getElementById("type-select").value;

            const resultDiv = document.getElementById("search-result");
            resultDiv.innerHTML = ""; // Clear trước

            // ✅ Kiểm tra: nếu không chọn gì cả thì cảnh báo
            if (!city && !district && !type) {
                alert("Vui lòng chọn ít nhất một tiêu chí để tìm kiếm.");
                return; // ❌ Không tìm kiếm nếu trống hoàn toàn
            }

// ✅ Ẩn danh sách ban đầu
            document.getElementById("original-product-list").style.display = "none";

            // ✅ Gọi hàm thay vì khai báo lại const matched
            const matched = searchMatchedProperty(city, district, type);

            if (!matched) {
                resultDiv.innerHTML = `<p class="text-center mt-4">Không tìm thấy bất động sản phù hợp.</p>`;
                return;
            }

            console.log("Matched: ", matched);

            // Xóa kết quả cũ
            resultDiv.innerHTML = "";


            const rowDiv = document.createElement("div");
            rowDiv.className = "row justify-content-center mt-4";

            matched.forEach(item => {
                const colDiv = document.createElement("div");
                colDiv.className = "col-12 col-md-4";

                const productDiv = document.createElement("div");
                productDiv.className = "product1 vip";

                // Ảnh
                const imageDiv = document.createElement("div");
                imageDiv.className = "product1-image position-relative";
                imageDiv.style.height = "200px";
                imageDiv.style.overflow = "hidden";
                imageDiv.innerHTML = `<img src="${item.image}" alt="${item.name}" style="width: 100%; height: 100%; object-fit: cover;">`;

                // Nội dung
                const contentDiv = document.createElement("div");
                contentDiv.className = "product1-conntent";

                const headerDiv = document.createElement("div");
                headerDiv.className = "product1-conntent-header";

                const titleLink = document.createElement("a");
                titleLink.href = "#";
                titleLink.textContent = item.name;
                headerDiv.appendChild(titleLink);

                const descriptionSpan = document.createElement("span");
                descriptionSpan.className = "product1-conntent-title";
                descriptionSpan.textContent = item.description || "Đang cập nhật...";

                const ul = document.createElement("ul");
                ul.className = "product1-conntent-list";

                const li1 = document.createElement("li");
                li1.innerHTML = `<i class='fa-solid fa-location-dot'></i>` + item.address;

                const li2 = document.createElement("li");
                li2.innerHTML = `<i class="fa-solid fa-building"></i> Loại BĐS:` + item.typeText;

                const li3 = document.createElement("li");
                li3.innerHTML = `<i class="fa-solid fa-earth-asia"></i> Diện tích:` + item.area;

                ul.append(li1, li2, li3);

                const footerDiv = document.createElement("div");
                footerDiv.className = "product1-footer";

                const priceSpan = document.createElement("span");
                priceSpan.className = "product1-footer-cost";
                priceSpan.textContent = item.price;

                const detailBtn = document.createElement("button");
                detailBtn.className = "product1-footer-detail";
                const detailLink = document.createElement("a");
                detailLink.href = "#";
                detailLink.textContent = "Xem chi tiết";
                detailLink.style.color = "#fff";
                detailBtn.appendChild(detailLink);

                footerDiv.append(priceSpan, detailBtn);

                contentDiv.append(headerDiv, descriptionSpan, ul);
                productDiv.append(imageDiv, contentDiv, footerDiv);
                colDiv.appendChild(productDiv);
                rowDiv.appendChild(colDiv);
            });

            resultDiv.appendChild(rowDiv);


        });
    </script>

    <script>
        document.getElementById("reset-btn").addEventListener("click", function () {
            // Reset dropdowns
            document.getElementById("city-select").value = "";
            document.getElementById("district-select").innerHTML = '<option value="">-- Chọn quận --</option>';
            document.getElementById("type-select").value = "";

            // Xóa kết quả tìm kiếm
            document.getElementById("search-result").innerHTML = "";

            // Hiện lại danh sách gốc
            document.querySelector(".product").style.display = "block";
        });
    </script>

    <script>
        document.addEventListener("DOMContentLoaded", function () {
            const container = document.querySelector("#original-product-list .container .row");

            fetch("/data.json") // Đường dẫn phải đúng
                .then(response => response.json())
                .then(data => {
                    container.innerHTML = ""; // Xóa toàn bộ HTML cũ

                    data.forEach(item => {
                        const col = document.createElement("div");
                        col.className = "col-12 col-md-4 mb-3";

                        col.innerHTML = `
                <div class="product1 vip">
                    <div class="product1-image new">

                    </div>
                    <div class="product1-conntent">
                        <div class="product1-conntent-header">
                            <a href="#">` + item.name + `</a>
                        </div>
                        <span class="product1-conntent-title">` + item.description + `</span>
                        <ul class="product1-conntent-list">
                            <li class="product1-conntent-item"><i class="fa-solid fa-location-dot"></i> <span>` + item.address + `</span></li>
                            <li class="product1-conntent-item"><i class="fa-solid fa-building"></i> <span>Loại BĐS:` + item.typeText + `</span></li>
                            <li class="product1-conntent-item"><i class="fa-solid fa-earth-asia"></i> <span>Diện tích:` + item.area + `</span></li>
                        </ul>
                    </div>
                    <div class="product1-footer">
                        <span class="product1-footer-cost">` + item.price +`</span>
                        <button class="product1-footer-detail" data-bs-toggle="modal" data-bs-target="#contactModal">
    Liên hệ
</button>


                    </div>
                </div>
                `;

                        container.appendChild(col);
                    });
                })
                .catch(error => {
                    console.error("Lỗi khi load data.json: ", error);
                });
        });
    </script>


    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>

    <!-- Modal Liên hệ -->
    <div class="modal fade" id="contactModal" tabindex="-1" aria-labelledby="contactModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content text-center">
                <div class="modal-header">
                    <h5 class="modal-title w-100" id="contactModalLabel">Thông tin liên hệ</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Đóng"></button>
                </div>
                <div class="modal-body">
                    <p>Bạn thích căn này chứ?</p>
                    <p>Vui lòng liên hệ số điện thoại <strong>0965102936</strong> để được tư vấn chi tiết nhất.</p>
                </div>
                <div class="modal-footer justify-content-center">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Đóng</button>
                </div>
            </div>
        </div>
    </div>



</body>

</html>