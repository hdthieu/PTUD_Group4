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
    hinhAnh VARCHAR(MAX),
	chucVu nvarchar(20) NOT NULL
);

CREATE TABLE TaiKhoan(
	tenTaiKhoan varchar(15) PRIMARY KEY,
	matKhau varchar(10) NOT NULL,
	quyenTruyCap nvarchar(15) NOT NULL,
	maNhanVien varchar(10) ,
	FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
);

CREATE TABLE NhaCungCap(
	maNhaCungCap varchar(15) PRIMARY KEY,
	tenNhaCungCap nvarchar(25) NOT NULL,
	diaChi nvarchar(30) NOT NULL,
	soDienThoai int NOT NULL,
);

CREATE TABLE SanPham (
    maSP VARCHAR(15) PRIMARY KEY,
    tenSP NVARCHAR(15) NOT NULL,
    giaBan float,
	giaNhap float,
    soLuong INT NOT NULL,
    maloaiSP VARCHAR (10),
    maNhaCungCap VARCHAR(15),
    hinhAnh VARCHAR(MAX),
	FOREIGN KEY (maNhaCungCap) REFERENCES NhaCungCap(maNhaCungCap),
);
Alter table SanPham 
ADD Constraint checkGia Check (giaBan > giaNhap)

CREATE TABLE ChiTietHoaDon(
	maHoaDon varchar(15) PRIMARY KEY,
	maSP varchar(15),
	soLuong int NOT NULL,
	donGiaBan float NOT NULL
	FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);

CREATE TABLE HoaDon(
	maHoaDon varchar(15) PRIMARY KEY,
	ngayTao Date,
	maKH varchar(15),
	maNhanVien varchar(10),
	FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
	FOREIGN KEY (maHoaDon) REFERENCES ChiTietHoaDon(maHoaDon),
	FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
);

CREATE TABLE PhieuDatHang (
    maPhieuDatHang varchar(15) NOT NULL PRIMARY KEY,
    ngayTaoPhieuDatHang Date NOT NULL,
    maKH varchar(15),
    maNhanVien varchar(10),
    FOREIGN KEY (maKH) REFERENCES KhachHang(maKH),
    FOREIGN KEY (maNhanVien) REFERENCES NhanVien(maNhanVien)
);

CREATE TABLE ChiTietPhieuDatHang (
    maPhieuDatHang varchar(15) PRIMARY KEY,
    donGiaBan float NOT NULL,
    soLuong int NOT NULL,
    maSP varchar(15),
    FOREIGN KEY (maPhieuDatHang) REFERENCES PhieuDatHang(maPhieuDatHang),
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);


CREATE TABLE LoaiSP (
    maLoai varchar(15) PRIMARY KEY ,
    tenLoai float NOT NULL,
    maSP varchar(15),
    FOREIGN KEY (maSP) REFERENCES SanPham(maSP)
);



INSERT INTO NhanVien (maNhanVien, tenNhanVien, diaChi, soDienThoai, gioiTinh, ngaySinh, hinhAnh, chucVu)
VALUES ('QL001', 'Nguyễn Văn', 'Quận Gò Vấp, HCM', 0987563874, 'Nam', '1990-01-15', 'link_hinh_anh1', 'Quản Lý');

INSERT INTO TaiKhoan (tenTaiKhoan, matKhau, quyenTruyCap, maNhanVien)
VALUES ('nguyenvan', '123', 'Quản Lý', 'QL001');
