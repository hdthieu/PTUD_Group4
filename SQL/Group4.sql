CREATE DATABASE GROUP4
USE GROUP4
CREATE TABLE KhachHang(
	maKH varchar(15) PRIMARY KEY,
	tenKH nvarChar(25) NOT NULL,
	diaChi nvarchar(30) NOT NULL,
	soDienThoai int NOT NULL,
	gioiTinh nvarchar(10) CHECK (gioiTinh IN ('Nam', 'Nữ'))
);

CREATE TABLE NhanVien(
    maNhanVien varchar(10) PRIMARY KEY ,
    tenNhanVien nvarchar(25) NOT NULL,
    diaChi nvarchar(30) NOT NULL,
    soDienThoai int NOT NULL,
	gioiTinh nvarchar(10) CHECK (gioiTinh IN ('Nam', 'Nữ')),
    ngaySinh Date,
    hinhAnh VARCHAR(MAX)
);

CREATE TABLE NhanVienThongKe (
    maNhanVien varchar(10) PRIMARY KEY,
	chucVu nvarchar(20) NOT NULL,
    FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
);

CREATE TABLE NhanVienQuanLy (
    maNhanVien varchar(10) PRIMARY KEY,
	chucVu nvarchar(20) NOT NULL,
    FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
);

CREATE TABLE NhanVienBanHang (
    maNhanVien varchar(10) PRIMARY KEY,
	chucVu nvarchar(20) NOT NULL,
    FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
);

CREATE TABLE TaiKhoan(
	tenTaiKhoan varchar(15) PRIMARY KEY,
	matKhau varchar(10) NOT NULL,
	quyenTruyCap nvarchar(15) NOT NULL,
	maNhanVien varchar(10) ,
	FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
);
CREATE TABLE LoaiSP(
	maloaiSP varchar(10) PRIMARY KEY,
	tenLoaiSP nvarchar(15) NOT NULL
);
CREATE TABLE NhaCungCap(
	maNhaCungCap varchar(15) PRIMARY KEY,
	tenNhaCungCap nvarchar(25) NOT NULL,
	diaChi nvarchar(30) NOT NULL,
	soDienThoai int NOT NULL,
);
CREATE TABLE SanPham(
	maSP varchar(15) PRIMARY KEY,
	tenSP nvarchar(15) NOT NULL,
	giaSP float NOT NULL,
	donViTinh varchar(5) NOT NULL,
	soLuong int NOT NULL,
	maloaiSP varchar(10),
	maNhaCungCap varchar(15),
	hinhAnh VARCHAR(MAX),
	FOREIGN KEY (maloaiSP) REFERENCES LoaiSP(maloaiSP),
	FOREIGN KEY (maNhaCungCap) REFERENCES NhaCungCap(maNhaCungCap)
);

CREATE TABLE ChiTietHoaDon(
	maHoaDon varchar(15) PRIMARY KEY,
	maSP varchar(15),
	soLuong int NOT NULL,
	donGia float NOT NULL
	FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);


CREATE TABLE HoaDon(
	maHoaDon varchar(15) PRIMARY KEY,
	ngayTao Date,
	thanhTien float NOT NULL,
	maKH varchar(15),
	maNhanVienBanHang varchar(10),
	FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
	FOREIGN KEY (maHoaDon) REFERENCES ChiTietHoaDon(maHoaDon),
	FOREIGN KEY (maNhanVienBanHang) REFERENCES NhanVienBanHang(maNhanVien)
);

CREATE TABLE DonDatHang(
	maDonDatHang varchar(15) NOT NULL PRIMARY KEY,
	ngayTaoDonDatHang Date NOT NULL,
	tongTien float NOT NULL,
	maKH varchar(15),
	tenKH nvarChar(25),
	soDienThoai int NOT NULL,
	diaChi nvarchar(30) NOT NULL,
	maSP varchar(15),
	tenSP nvarchar(15),
	FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
	FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);

CREATE TABLE ChiTietDonDatHang(
	maDonHang varchar(15) PRIMARY KEY,
	donGia float NOT NULL,
	soLuong int NOT NULL,
	maSP varchar(15),
	tenSP varchar(15),
	FOREIGN KEY (maDonHang) REFERENCES DonDatHang(maDonDatHang)
);





