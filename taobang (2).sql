	--b1
	create database PRO1041_cuoi
	--b2
	Go
	USE PRO1041_cuoi
	go
	CREATE TABLE [dbo].[DoiHang](
		[MaPhieuDoi] [varchar](10) Primary key  NOT NULL,
		[NgayDoi] [date] NULL,
		[TrangThai] [bit] NULL,
		[MaChiTiet] int,
		[MaLyDo]int,
		[MaSPCu]int,
		[MaSPmoi]int 
	) 
	GO
	/****** Object:  Table [dbo].[DOIHANG_CHITIET]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[DOIHANG_CHITIET](
		[MaChiTiet] int identity(1,1) primary key NOT NULL,
		[TheTrang] [nvarchar](max) NOT NULL,
		[SoLuong] [int] NOT NULL,

	) 
	GO
	/****** Object:  Table [dbo].[DOIHANG_LYDO]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[DOIHANG_LYDO](
		[MaLyDo]int identity(1,1) primary key not null,
		[LyDo] [nvarchar](max) NOT NULL,

	) 
	GO
	/****** Object:  Table [dbo].[DOIHANG_NGAYDOI]    Script Date: 11/09/23 23:27:15 ******/


	/****** Object:  Table [dbo].[DOIHANG_SANPHAMCU]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[DOIHANG_SANPHAMCU](
		[MaSPCu]int identity(1,1) primary key not null,
		[MaSanPhamCu] [varchar](10) NOT NULL,
	) 
	GO
	/****** Object:  Table [dbo].[DOIHANG_SANPHAMMOI]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[DOIHANG_SANPHAMMOI](
		[MaSPmoi]int identity(1,1) primary key not null,
		[MaSanPhammoi] [varchar](10) NOT NULL
	) 
	GO
	/****** Object:  Table [dbo].[DotGiamGia]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[DotGiamGia](
		[MaDot] [varchar](10) primary key NOT NULL,
		[NgayKetThuc] [date]NOT NULL,
		[GhiChu] [nvarchar](max) NULL,
		[PhanTramTienGiam] [float] NULL,
		[SoTienGiam] [float]  NULL,
		[NgayBatDau] [date] NOT NULL,
		[MaLoai] int,
			[MaSanPhamApDung] int,
			[MaTrangThai] int,


	) 
	GO
	/****** Object:  Table [dbo].[DOTGIAMGIA_LoaiGiamGia]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[DOTGIAMGIA_LoaiGiamGia](
		[MaLoai] int identity(1,1) primary key NOT NULL,
		[TenLoai] [nvarchar](max) NOT NULL,
		[GhiChu] [nvarchar](max) NOT NULL,
		[TrangThai] [bit] NOT NULL,
	)
	GO
	/****** Object:  Table [dbo].[DOTGIAMGIA_PhanTramGiamGia]    Script Date: 11/09/23 23:27:15 ******/

	GO
	/****** Object:  Table [dbo].[DOTGIAMGIA_SanPhamApDung]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[DOTGIAMGIA_SanPhamApDung](
		[MaSanPhamApDung] int identity(1,1) primary key NOT NULL,
		[MaSanPham] [varchar](10) NOT NULL,
	) 
	GO
	/****** Object:  Table [dbo].[DOTGIAMGIA_TrangThaiDotGiamGia]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[DOTGIAMGIA_TrangThaiDotGiamGia](
		[MaTrangThai] int identity(1,1) primary key NOT NULL,
		[TenTrangThai] [nvarchar](max) NOT NULL,
		[GhiChu] [nvarchar](max) NOT NULL,
		[TrangThai] [bit] NOT NULL,
	) 
	GO
	/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[HoaDon](
		[MaHoaDon] int identity(1,1) primary key NOT NULL,
		[IDKhachHang] int  NULL,
		[MaNhanVien] [varchar](10)NOT NULL ,
		[MaSanPham] [varchar](10) NULL ,
		[MaPhieu] [varchar](10) NULL,
		[MaPhieuDoi] [varchar](10) NULL,
		[GiaTri] [float] NULL ,
		[MaPhieuGiamGia] [varchar](10) NULL ,
		[MaDotGiamGia] [varchar](10) NULL ,
		[SoDT] [varchar](15)  NULL,
		[NgayTao] [date]  NULL,
		[HinhThucTT] [bit] null,
		[HinhThucNhanHang] [bit] null,
		[TrangThai] [int]  NULL,
		[GhiChu] [varchar](200) null

	)

	GO
	/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[KhachHang](
		[IDKhachHang] int identity(1,1)  primary key NOT NULL,
		
		[TenKhachHang] [nvarchar](max) ,
		[GioiTinh] [bit] ,
		[NgaySinh] [date],
		[Email] [nvarchar](max) ,
		[SDT] [nvarchar](max) ,
		diaChi nvarchar(100),
		hangKhach bit ,
		[MaDiaChi] int,
		[MaFeedback] int,
		[MaTraCuuLichSu] int,
		[MaTichDiemKH] int
	) 
	GO
	/****** Object:  Table [dbo].[KHACHHANG_DIACHI]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[KHACHHANG_DIACHI](
		[MaDiaChi] int identity(1,1) primary key not null,
		[SoNha] [nvarchar](50),
		[Phuong] [nvarchar](50) ,
		[Quan] [nvarchar](50) ,
		[ThanhPho] [nvarchar](50) ,
	)
	GO
	/****** Object:  Table [dbo].[KHACHHANG_FEEDBACK]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[KHACHHANG_FEEDBACK](
		[MaFeedback] int identity(1,1)  primary key NOT NULL,
		[NoiDungPhanHoi] [nvarchar](100) ,
		[NgayPhanHoi] [date],
	)
	GO
	/****** Object:  Table [dbo].[KHACHHANG_LICHSUMUAHANG]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[KHACHHANG_LICHSUMUAHANG](
		[MaTraCuuLichSu] int identity(1,1)  primary key NOT NULL,
		[MaSanPham] [varchar](10),
		[NgayMua] [date] ,
		soLuong int ,
		tongTien float,
		ThanhToan bit ,
	) 
	GO
	/****** Object:  Table [dbo].[KHACHHANG_TICHDIEM]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[KHACHHANG_TICHDIEM](
		[MaTichDiemKH] int identity(1,1)  primary key NOT NULL,
		[TongDiemTichLuy] [int] ,
		[DiemDaDung] [int] ,
		[DiemConLai] [int] ,
		
	) 
	GO
	/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[NhanVien](
		[MaNhanVien] [varchar](10)  primary key NOT NULL,
		[NgaySinh] [date] NOT NULL,
		[MatKhau] [nvarchar](max)NOT NULL ,
		[SDT] [nvarchar](max)NOT NULL ,
		[GioiTinh] [bit]NOT NULL ,
		[HoTen] [nvarchar](max)NOT NULL ,
		[DiaChi] [nvarchar](max)NOT NULL,
		[TrangThai] [bit] NOT NULL,
		[MaAnh] int,
		[MaCa] int,
		[MaCV] int,
		[MaLuong] int
	) 
	GO


	/****** Object:  Table [dbo].[NHANVIEN_Anh]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[NHANVIEN_Anh](
		[MaAnh] int identity(1,1)  primary key NOT NULL,
		[AnhURL] [nvarchar](50) NULL,
	) 
	GO
	/****** Object:  Table [dbo].[NHANVIEN_CaLam]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[NHANVIEN_CaLam](
		[MaCa] int identity(1,1)  primary key NOT NULL,
		[TenCa] [nvarchar](50) NULL,
		) 
	GO
	/****** Object:  Table [dbo].[NHANVIEN_ChucVu]    Script Date: 11/09/23 23:27:15 ******/

	GO
	CREATE TABLE [dbo].[NHANVIEN_ChucVu](
		[MaCV] int identity(1,1)  primary key NOT NULL,
		[TenCV] [nvarchar](50) NOT NULL,
	) 
	GO
	/****** Object:  Table [dbo].[NHANVIEN_Luong]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[NHANVIEN_Luong](
		[MaLuong] int identity(1,1)  primary key NOT NULL,
		[LuongCoban] [int] NULL,
		[LuongTangCa] [int] NULL,
		[ThueKhauTru] [nvarchar](50) NULL,
		)
	GO
	/****** Object:  Table [dbo].[PhieuGiamGia]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PhieuGiamGia](
		[MaPhieuGiamGia] [varchar](10)  primary key NOT NULL,
		[MaDieuKien] [int] ,
		[TrangThai] [bit] NULL,
		[MaLoaiPhieu] [int] NOT NULL,
		[MucGiam] [float] NOT NULL,
		[NgayHetHan] [date] NOT NULL,
		[MaMucGiam] [int],
		[MaTrangThai] [int]
	) 
	GO
	/****** Object:  Table [dbo].[PhieuGiamGia_DieuKienApDung]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PhieuGiamGia_DieuKienApDung](
		[MaDieuKien] [int] IDENTITY(1,1)  primary key NOT NULL,
		[TenDieuKien] [nvarchar](max) NOT NULL,
	) 
	GO
	/****** Object:  Table [dbo].[PhieuGiamGia_LoaiPhieu]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PhieuGiamGia_LoaiPhieu](
		[MaLoaiPhieu] [int] IDENTITY(1,1)  primary key NOT NULL,
		[TenLoaiPhieu] [nvarchar](max) NOT NULL,
		) 
	GO
	/****** Object:  Table [dbo].[PhieuGiamGia_MucGiam]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PhieuGiamGia_MucGiam](
		[MaMucGiam] [int] IDENTITY(1,1)  primary key NOT NULL,
		[TyLeGiam] [float] NOT NULL,
	)
	GO
	/****** Object:  Table [dbo].[PhieuGiamGia_TrangThai]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PhieuGiamGia_TrangThai](
		[MaTrangThai] [int] IDENTITY(1,1)  primary key NOT NULL,
		[TenTrangThai] [nvarchar](max) NOT NULL,
		) 
	GO
	/****** Object:  Table [dbo].[PhieuGiaoHang]    Script Date: 11/09/23 23:27:15 ******/
	GO
	--CREATE TABLE [dbo].[PhieuGiaoHang](
	--	[MaPhieu] [varchar](10)  primary key NOT NULL,
	--	[NgayGiao] [date]NOT NULL,
	--	[NguoiNhan] [nvarchar](max) NOT NULL,
	--	[Sdt] [nvarchar](10)NOT NULL,
	--	[GhiChu] [nvarchar](max) NULL,
	--	[MaDiaDiem] int,
	--	[MaVanChuyen] int,
	--	[MaTrangThai] int
	--) 
	--GO
	--/****** Object:  Table [dbo].[PHIEUGIAOHANG_DiaDiemGiaoHang]    Script Date: 11/09/23 23:27:15 ******/
	--GO
	--CREATE TABLE [dbo].[PHIEUGIAOHANG_DiaDiemGiaoHang](
	--	[MaDiaDiem] int identity(1,1) primary key not null,
	--	[MaTP] [nvarchar](50) NOT NULL,
	--	[TenTP] [nvarchar](50)NOT NULL ,
	--	[MaQH] [nvarchar](50)NOT NULL ,
	--	[TenQH] [nvarchar](50)NOT NULL ,
	--	) 
	--GO
	--/****** Object:  Table [dbo].[PHIEUGIAOHANG_thongTinVanChuyen]    Script Date: 11/09/23 23:27:15 ******/
	--GO
	--CREATE TABLE [dbo].[PHIEUGIAOHANG_thongTinVanChuyen](
	--	[MaVanChuyen] int identity(1,1) primary key not null,
	--	[NguoiVanChuyen] [nvarchar](50)NOT NULL,
	--	[SDT] [nvarchar] (10)NOT NULL,
	--	) 
	--GO
	--/****** Object:  Table [dbo].[PHIEUGIAOHANG_TrangThai]    Script Date: 11/09/23 23:27:15 ******/
	--GO
	--CREATE TABLE [dbo].[PHIEUGIAOHANG_TrangThai](
	--	[MaTrangThai] int identity(1,1) primary key not null,
	--	[tenTrangThai] [nvarchar](50) NOT NULL,
	--	) 
	--GO


	CREATE TABLE [dbo].[PhieuGiaoHang](
		[MaPhieu] [varchar](10)  primary key NOT NULL,
		[NgayGiao] [date]NOT NULL,
		[NguoiNhan] [nvarchar](max) NOT NULL,
		[Sdt] [nvarchar](10)NOT NULL,
		Email Nvarchar(30) not null,
		TrangThaiThanhToan Nvarchar(30) not null,
		[GhiChu] [nvarchar](max) NULL,
		[MaDiaDiem] int,
		[MaVanChuyen] int,
		[MaTrangThai] int,
		MaThanhToan int
	) 
	GO
	/****** Object:  Table [dbo].[PHIEUGIAOHANG_DiaDiemGiaoHang]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PHIEUGIAOHANG_DiaDiemGiaoHang](
		[MaDiaDiem] int identity(1,1) primary key not null,
		[Duong] [nvarchar](50) NOT NULL,
		[TenQH] [nvarchar](50)NOT NULL ,
		[TenTP] [nvarchar](50)NOT NULL ,	
		) 
	GO
	/****** Object:  Table [dbo].[PHIEUGIAOHANG_thongTinVanChuyen]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PHIEUGIAOHANG_thongTinVanChuyen](
		[MaVanChuyen] int identity(1,1) primary key not null,
		[NguoiVanChuyen] [nvarchar](50)NOT NULL,
		[SDTNguoiGiao] [nvarchar] (10)NOT NULL,
		) 

	/****** Object:  Table [dbo].[PHIEUGIAOHANG_TrangThai]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[PHIEUGIAOHANG_TrangThai](
		[MaTrangThai] int identity(1,1) primary key not null,
		[tenTrangThai] [nvarchar](50) NOT NULL,
		) 
	GO

	GO
	Create table PhieuGiaoHang_ThanhToan (
	MaThanhToan int identity(1,1) primary key not null,
	NgayThanhToan date not null,
	SoTien Float not null,
	PhuongThucThanhToan Nvarchar(40) not null,
	TrangThai Nvarchar(30) not null
	)
	/****** Object:  Table [dbo].[SanPham]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[SanPham](
		[MaSanPham] [varchar](10)  primary key NOT NULL,
		[SoLuong] [int] ,
		[DonGia] [float] ,
		[MoTa] [nvarchar](max)  ,
		[TenSanPham] [nvarchar](max) ,
		[TenAnh] [nvarchar](50) ,
		[TenAnhQR] [nvarchar](50),
		[MaChatLieu] int,
		[MaLoaiSp] int,
		[MaNhaCC] int
	) 
	GO
	/****** Object:  Table [dbo].[SANPHAM_AnhSP]    Script Date: 11/09/23 23:27:15 ******/
	GO
	--CREATE TABLE [dbo].[SANPHAM_AnhSP](
	--	[MaAnh] int identity(1,1) primary key not null,
	--	[TenAnh] [nvarchar](50) NOT NULL,
	--	[TenAnhQR] [nvarchar](50) NOT NULL,
		
	--) 
	--GO
	/****** Object:  Table [dbo].[SANPHAM_ChatLieu]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[SANPHAM_ChatLieu](
		[MaChatLieu] int identity(1,1) primary key not null,
		[TenChatLieu] [nvarchar](50)
		
	)
	GO
	/****** Object:  Table [dbo].[SANPHAM_LoaiSP]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[SANPHAM_LoaiSP](
		[MaLoaiSp] int identity(1,1) primary key not null,
		[TenLoaiSP] [nvarchar](50) 
		
	) 
	GO
	/****** Object:  Table [dbo].[SANPHAM_NhaCungCap]    Script Date: 11/09/23 23:27:15 ******/
	GO
	CREATE TABLE [dbo].[SANPHAM_NhaCungCap](
		[MaNhaCC] int identity(1,1) primary key not null,
		[TenNhaCC] [nvarchar](50) ,
		[email] [nvarchar](50) ,
		[sdt] [nvarchar](50) ,
		[DiaChi] [nvarchar](50)
		) 

	alter table [dbo].[HoaDon]
		add foreign key ([IDKhachHang])references [dbo].[KhachHang]([IDKhachHang]),
		foreign key (MaNhanVien)references [dbo].[NhanVien](MaNhanVien),
		foreign key (MaSanPham)references	[dbo].[SanPham](MaSanPham),
		foreign key (MaPhieu)references	[dbo].[PhieuGiaoHang](MaPhieu),
		-- foreign key (MaPhieuGiamGia)references [dbo].[PhieuGiamGia](MaPhieuGiamGia),
		foreign key (MaDotGiamGia)references [dbo].[DotGiamGia]([MaDot]),
		foreign key (MaPhieuDoi)references	[dbo].[DoiHang](MaPhieuDoi)

	alter table [dbo].[DoiHang]
		add foreign key (MaChiTiet) references [dbo].[DOIHANG_CHITIET](MaChiTiet),
		foreign key (MaLyDo) references [dbo].[DOIHANG_LYDO](MaLyDo),
		foreign key (MaSPCu) references [dbo].[DOIHANG_SANPHAMCU](MaSPCu),
		foreign key (MaSPmoi) references [dbo].[DOIHANG_SANPHAMMOI](MaSPmoi)



	alter table [dbo].[DotGiamGia]
		add foreign key (MaLoai)references[dbo].[DOTGIAMGIA_LoaiGiamGia](MaLoai),
		foreign key (MaSanPhamApDung)references[dbo].[DOTGIAMGIA_SanPhamApDung](MaSanPhamApDung),
		foreign key (MaTrangThai)references[dbo].[DOTGIAMGIA_TrangThaiDotGiamGia](MaTrangThai)

	alter table [dbo].[DOTGIAMGIA_SanPhamApDung]
		add foreign key (MaSanPham)references[dbo].[SanPham](MaSanPham)

	alter table [dbo].[KhachHang]
		add foreign key (MaDiaChi) references [dbo].[KHACHHANG_DIACHI](MaDiaChi),
		foreign key ([MaFeedback]) references [dbo].[KHACHHANG_FEEDBACK]([MaFeedback]),
		foreign key ([MaTraCuuLichSu]) references [dbo].[KHACHHANG_LICHSUMUAHANG]([MaTraCuuLichSu]),
		foreign key ([MaTichDiemKH]) references [dbo].[KHACHHANG_TICHDIEM]([MaTichDiemKH])

	alter table [dbo].[KHACHHANG_LICHSUMUAHANG]
		add foreign key (MaSanPham)references[dbo].[SanPham](MaSanPham)

	alter table [dbo].[NhanVien]
		add foreign key ([MaAnh])references[dbo].[NHANVIEN_Anh]([MaAnh]),
		foreign key ([MaCa])references[dbo].[NHANVIEN_CaLam]([MaCa]),
		foreign key ([MaCV])references[dbo].[NHANVIEN_ChucVu]([MaCV]),
		foreign key ([MaLuong])references[dbo].[NHANVIEN_Luong]([MaLuong])

	alter table [dbo].[PhieuGiamGia]
		add foreign key ([MaDieuKien])references[dbo].[PhieuGiamGia_DieuKienApDung]([MaDieuKien]),
		foreign key ([MaLoaiPhieu])references[dbo].[PhieuGiamGia_LoaiPhieu]([MaLoaiPhieu]),
		foreign key ([MaMucGiam])references[dbo].[PhieuGiamGia_MucGiam]([MaMucGiam]),
		foreign key ([MaTrangThai])references[dbo].[PhieuGiamGia_TrangThai]([MaTrangThai])


	--alter table [dbo].[PhieuGiaoHang]
	--	add foreign key ([MaDiaDiem])references[dbo].[PHIEUGIAOHANG_DiaDiemGiaoHang]([MaDiaDiem]),
	--	foreign key ([MaVanChuyen])references[dbo].[PHIEUGIAOHANG_thongTinVanChuyen]([MaVanChuyen]),
	--	foreign key ([MaTrangThai])references[dbo].[PHIEUGIAOHANG_TrangThai]([MaTrangThai])
	alter table [dbo].[PhieuGiaoHang]
		add foreign key ([MaDiaDiem])references[dbo].[PHIEUGIAOHANG_DiaDiemGiaoHang]([MaDiaDiem]),
		foreign key ([MaVanChuyen])references[dbo].[PHIEUGIAOHANG_thongTinVanChuyen]([MaVanChuyen]),
		foreign key (MaThanhToan) references PhieuGiaoHang_ThanhToan(MaThanhToan),
		foreign key ([MaTrangThai])references[dbo].[PHIEUGIAOHANG_TrangThai]([MaTrangThai])


	alter table [dbo].[SanPham]
		add CONSTRAINT FK__SanPham__SANPHAM_ChatLieu
		foreign key ([MaChatLieu])references[dbo].[SANPHAM_ChatLieu]([MaChatLieu]) ON DELETE No action,
		CONSTRAINT FK__SanPham__SANPHAM_LoaiSP
		foreign key ([MaLoaiSp])references[dbo].[SANPHAM_LoaiSP]([MaLoaiSp])ON DELETE No action,
		CONSTRAINT FK__SanPham__SANPHAM_NhaCungCap
		foreign key ([MaNhaCC])references[dbo].[SANPHAM_NhaCungCap]([MaNhaCC])ON DELETE No action
	go 
	use PRO1041
	go
	create table [dbo].[ChiTietHoaDon](
		[MaChiTietHD] int identity(1,1) primary key not null,
		[MaHoaDon] int not null,
		[MaSanPham] varchar(10) not null,
		[TenSanPham] varchar(50)not null,
		[SoLuong] int not null,
		[TongTien] float not null
	);
	go
	-- Create the foreign key constraint
	alter table [dbo].[ChiTietHoaDon]
	add constraint fk_ChiTietHoaDon_HoaDon
	foreign key(MaHoaDon)
	references [dbo].[HoaDon](MaHoaDon);
go
-- Tạo bảng hoadon_trangthai
CREATE TABLE hoadon_trangthai (
    ma_trangthai INT PRIMARY KEY,
    ten_trangthai NVARCHAR(255)
);
go
-- Thêm 3 bản ghi
INSERT INTO hoadon_trangthai (ma_trangthai, ten_trangthai) VALUES (1, N'Đã thanh toán');
INSERT INTO hoadon_trangthai (ma_trangthai, ten_trangthai) VALUES (2, N'Chưa thanh toán');
INSERT INTO hoadon_trangthai (ma_trangthai, ten_trangthai) VALUES (3, N'Đã hủy');


CREATE PROCEDURE ThemPhieuGiaoHang_1234
    @MaPhieu VARCHAR(10),
    @NgayGiao DATE,
    @NguoiNhan NVARCHAR(255),
    @Sdt NVARCHAR(10),
    @Email NVARCHAR(30),
    @TrangThaiThanhToan NVARCHAR(30),
    @GhiChu NVARCHAR(MAX),
    @NguoiVanChuyen NVARCHAR(50),
	--@SDTGiao Nvarchar(10),
    @soTien FLOAT,
    @trangthaigiaohang NVARCHAR(50)

AS
BEGIN
set nocount on;
   

    DECLARE @tt INT;
    INSERT INTO PhieuGiaoHang_ThanhToan (NgayThanhToan, PhuongThucThanhToan, SoTien, TrangThai)
    VALUES (GETDATE(), 'PhuongThuc', @soTien, @TrangThaiThanhToan);
    SET @tt = SCOPE_IDENTITY();
	 DECLARE @nvc INT;
    INSERT INTO PHIEUGIAOHANG_thongTinVanChuyen (NguoiVanChuyen,SDTNguoiGiao)
    VALUES (@NguoiVanChuyen,@Sdt);
    SET @nvc = SCOPE_IDENTITY();
    DECLARE @ttt INT;
    INSERT INTO PhieuGiaoHang_TrangThai (tenTrangThai)
    VALUES (@trangthaigiaohang);
    SET @ttt = SCOPE_IDENTITY();
   

    INSERT INTO PhieuGiaoHang (MaPhieu, NgayGiao, NguoiNhan, Sdt, Email, TrangThaiThanhToan, GhiChu, MaVanChuyen, MaThanhToan, MaTrangThai)
    VALUES (@MaPhieu, @NgayGiao, @NguoiNhan, @Sdt, @Email, @TrangThaiThanhToan, @GhiChu, @nvc, @tt, @ttt);
END;



CREATE PROCEDURE ThemPhieuGiaoHang_12345
    @MaPhieu VARCHAR(10),
    @NgayGiao DATE,
    @NguoiNhan NVARCHAR(255),
    @Sdt NVARCHAR(10),
    @Email NVARCHAR(30),
    @TrangThaiThanhToan NVARCHAR(30),
    @GhiChu NVARCHAR(MAX),
    @NguoiVanChuyen NVARCHAR(50),
	--@SDTGiao Nvarchar(10),
    @soTien FLOAT,
    @trangthaigiaohang NVARCHAR(50)

AS
BEGIN
set nocount on;
   

    DECLARE @tt INT;
    INSERT INTO PhieuGiaoHang_ThanhToan (NgayThanhToan, PhuongThucThanhToan, SoTien, TrangThai)
    VALUES (GETDATE(), 'PhuongThuc', @soTien, @TrangThaiThanhToan);
    SET @tt = SCOPE_IDENTITY();
	 DECLARE @nvc INT;
    INSERT INTO PHIEUGIAOHANG_thongTinVanChuyen (NguoiVanChuyen,SDTNguoiGiao)
    VALUES (@NguoiVanChuyen,@Sdt);
    SET @nvc = SCOPE_IDENTITY();
    DECLARE @ttt INT;
    INSERT INTO PhieuGiaoHang_TrangThai (tenTrangThai)
    VALUES (@trangthaigiaohang);
    SET @ttt = SCOPE_IDENTITY();

    UPDATE PhieuGiaoHang
    SET NgayGiao = @NgayGiao,
        NguoiNhan = @NguoiNhan,
        Sdt = @Sdt,
        Email = @Email,
        TrangThaiThanhToan = @TrangThaiThanhToan,
        GhiChu = @GhiChu,
        MaVanChuyen = @nvc,
        MaThanhToan = @tt,
        MaTrangThai = @ttt
    WHERE MaPhieu = @MaPhieu;
END;






----san pham
insert into SANPHAM_ChatLieu(TenChatLieu) values
(N'cát'),
(N'Đồng'),
(N'Sắt'),
(N'Nhựa')
go
insert into SANPHAM_LoaiSP(TenLoaiSP) values
(N'phụ kiện'),
(N'đồ chơi')
go
insert into SANPHAM_NhaCungCap(TenNhaCC, email, sdt, DiaChi) values
(N'Paws & Whiskers Boutique', N'pwb@gmail.com', N'0716552765', N'Hà Nội'),
(N'PetParadise Haven', N'pph@gmail.com', N'0355167189', N'Yên Bái'),
(N'FurryFriends Emporium', N'ffe@gmail.com', N'0345155676', N'Hà Nội')
go
insert into SanPham	values
('Sp001', 27, 188000, N'Cát mùi trà xanh hạt to ', N'Cát mèo Pets',N'jpg1',N'jpg1',  1, 1, 1),
('Sp002', 7, 288000, N'bóng nhỏ cho các pet chơi ', N'Bóng hơi  ',N'jpg1',N'jpg1',  4, 2, 2),
('Sp003', 27, 190000, N'Dài 2m có thể tự thu lại ', N'Xích mèo Pets',N'jpg1',N'jpg1',  3, 1, 3),
('Sp004', 20, 18000, N'Giảm stress cho mèo ', N'Cỏ mèo  ',N'jpg1',N'jpg1',  1, 2, 2),
('Sp005', 7, 188000, N'Dài 2m có thể tự thu lại ', N'Xích Chó Pets',N'jpg1',N'jpg1',  3, 1, 1),
('Sp006', 0, 188000, N'To và rộng ', N'Bát ăn cho pet ',N'jpg1',N'jpg1',  4, 1, 2)

--KHACH HANG *************
go
INSERT INTO KHACHHANG_DIACHI (SoNha, Phuong, Quan, ThanhPho)
VALUES 
('123A', N'Phường 1', N'Quận  A', N'TP Hồ Chí Minh'),
('456B', N'Phường 2', N'Quận  A', N'TP Hà Nội '),
('789C', N'Phường 3', N'Quận  A', N'TP Đà Nẵng '),
('987D', N'Phường 4', N'Quận  A', N'TP Cần Thơ '),
('654E', N'Phường 5', N'Quận  A', N'TP Hải Phòng ');
go
INSERT INTO KHACHHANG_FEEDBACK (NoiDungPhanHoi, NgayPhanHoi)
VALUES 
(N'Sản phẩm tốt ', '2023-11-14'),
(N'Sản phẩm tốt', '2023-11-14'),
(N'Sản phẩm bình thường ', '2023-11-14'),
(N'Sản phẩm tốt', '2023-11-14'),
(N'Sản phẩm thường ', '2023-11-14');
go
INSERT INTO KHACHHANG_LICHSUMUAHANG (MaSanPham, NgayMua, soLuong, tongTien, ThanhToan)
VALUES 
('Sp001', '2023-11-14', 2, 100.5, 1),
('Sp002', '2023-11-14', 3, 75.0, 0),
('Sp003', '2023-11-14', 1, 50.25, 1),
('Sp004', '2023-11-14', 4, 120.75, 1),
('Sp005', '2023-11-14', 2, 90.0, 0);
go
INSERT INTO KHACHHANG_TICHDIEM (TongDiemTichLuy, DiemDaDung, DiemConLai)
VALUES 
(50, 10, 40),
(75, 20, 55),
(100, 30, 70),
(120, 40, 80),
(90, 15, 75);
go
INSERT INTO KhachHang (TenKhachHang, GioiTinh, NgaySinh, Email, SDT,diaChi ,hangKhach,MaDiaChi, MaFeedback, MaTraCuuLichSu, MaTichDiemKH)
VALUES 
(N'Vũ Anh Tài ', 1, '1990-05-15', 'tai@gmail.com', '0123456789',N'Hà Nội', 1, 1,1, 5, 1),
(N'Trần Thị Hoa ', 0, '1985-08-20', 'hoa@gmail.com', '0987654321',N'TP Hồ Chí Minh ', 1, 2,2, 2, 2),
(N'Lê Văn Luyện', 1, '1995-02-10', 'luyen@gmail.com', '0369852147',N'Hà Nội', 0, 3,3, 3, 3),
(N'Phạm Thị Hà ', 0, '2000-11-30', 'ha@gmail.com', '0999999999',N'TP Hồ Chí Minh', 0, 4,4, 4, 4),
(N'Hoàng Văn Vũ ', 1, '1978-07-25', 'vu@gmail.com', '0888888888',N'Hà Nội', 1,5, 5, 5, 5);


--DOT GIAM GIA
go
insert into DOTGIAMGIA_TrangThaiDotGiamGia(TenTrangThai, GhiChu, TrangThai) values
(N'Chờ', N'chưa đến thời điểm', 1),
(N'Đang', N'đang diễn ra', 2),
(N'Ngừng', N'đã kết thúc', 3),
(N'Hoãn', N'tạm dừng', 4)
go

insert into DOTGIAMGIA_SanPhamApDung(MaSanPham) values
('Sp006'),
('Sp004'),
('Sp005')
go
insert into DOTGIAMGIA_LoaiGiamGia(TenLoai, GhiChu, TrangThai) values
(N'Sale ngày trùng tháng', N'trừ tháng 7', 1),
(N'Sale ngày lễ', N'trừ tết dương lịch', 1)
go
insert into DotGiamGia values
('3J8K9', '2023-09-30', N'25 vé', 10, 8000, '2023-09-19', 1, 2, 4),
('7G4H6', '2023-08-29', N'24 vé', 10, 9000, '2023-08-16', 2, 3, 1),
('1D5F9', '2023-07-28', N'23 vé', 10, 10000, '2023-07-13', 1, 1, 1)

go
--DOIHANG*********

insert into DOIHANG_SANPHAMMOI(MaSanPhamMoi) values
('6Q7R2T8'),
('4G9Y1N6'),
('3A7K9H5'),
('8J2L6P4'),
('1D9S6F2')
go
insert into DOIHANG_SANPHAMCU(MaSanPhamCu) values
('4G9Y1N6'),
('4G9Y1N6'),
('4G6Y3N9'),
('4G9Y1N6'),
('3J9R5T2')
go
insert into DOIHANG_LYDO(LyDo) values
(N'chán'),
(N'dở'),
(N'thích thì đổi'),
(N'ko hợp phong thủy'),
(N'scam')
go
insert into DOIHANG_CHITIET(TheTrang, SoLuong) values
(N'99%', 1),
(N'98%', 1),
(N'97%', 1),
(N'96%', 1),
(N'95%', 1)
go
insert into DoiHang values
('4U6W9P2T5', '2023-08-12', 1, 1, 1, 1, 1),
('8H3Z7R1K0', '2023-07-11', 1, 2, 2, 2, 2),
('5X9Q2M4E7', '2023-06-10', 1, 3, 3, 3, 3),
('1N6Y8L3F2', '2023-05-09', 1, 4, 4, 4, 4),
('7D0V5B9G1', '2023-04-08', 0, 5, 5, 5, 5)
go
-- Thêm dữ liệu vào bảng PhieuGiaoHang_ThanhToan
INSERT INTO PhieuGiaoHang_ThanhToan (NgayThanhToan, SoTien, PhuongThucThanhToan, TrangThai)
VALUES 
    ('2023-11-20', 1500000, 'Credit Card', 'Da Thanh Toan'),
    ('2023-11-21', 2000000, 'Cash', 'Chua Thanh Toan'),
    ('2023-11-22', 1800000, 'Bank Transfer', 'Da Thanh Toan'),
    ('2023-11-23', 2200000, 'Credit Card', 'Chua Thanh Toan'),
    ('2023-11-24', 1700000, 'Cash', 'Da Thanh Toan'),
    ('2023-11-25', 1900000, 'Bank Transfer', 'Chua Thanh Toan'),
    ('2023-11-26', 2100000, 'Credit Card', 'Da Thanh Toan');
go
INSERT INTO PHIEUGIAOHANG_TrangThai (tenTrangThai)
VALUES 
    ('Da Giao Hang'),
    ('Dang Van Chuyen'),
    ('Chua Duyet'),
    ('Da Duyet'),
    ('Da Thanh Toan'),
    ('Dang Xu Ly'),
    ('Hoan Tat');
	go
	INSERT INTO PHIEUGIAOHANG_thongTinVanChuyen (NguoiVanChuyen, SDTNguoiGiao)
VALUES 
    ('Nguyen Hung', '0123456789'),
    ('Tran Loan', '0987654321'),
    ('Le Tuan', '0123456789'),
    ('Pham Hao', '0987654321'),
    ('Truong Van', '0123456789'),
    ('Nguyen Van', '0987654321'),
    ('Do Van', '0123456789');
	go
INSERT INTO PHIEUGIAOHANG_DiaDiemGiaoHang (Duong, TenQH, TenTP)
VALUES 
    ('Duong 1', 'Quan Hoang Mai', 'Ha Noi'),
    ('Duong 2', 'Quan Cau Giay', 'Ha Noi'),
    ('Duong 3', 'Quan Thanh Xuan', 'Ha Noi'),
    ('Duong 4', 'Quan 1', 'Ho Chi Minh City'),
    ('Duong 5', 'Quan Binh Thanh', 'Ho Chi Minh City'),
    ('Duong 6', 'Quan Go Vap', 'Ho Chi Minh City'),
    ('Duong 7', 'Quan Tan Phu', 'Ho Chi Minh City');
	go
INSERT INTO PhieuGiaoHang (MaPhieu, NgayGiao, NguoiNhan, Sdt, Email, TrangThaiThanhToan, GhiChu,MaDiaDiem,MaVanChuyen,MaThanhToan,MaTrangThai)
VALUES 
    ('PGH001', '2023-11-20', 'Nguyen Van Tuan', '0123456789', 'nguyenvana@example.com', 'DaThanhToan', '1',1,1,1,1),
    ('PGH002', '2023-11-21', 'Tran Thi Loan', '0987654321', 'tranthib@example.com', 'ChuaThanhToan', '2',2,2,2,2),
    ('PGH003', '2023-11-22', 'Le Van Hung', '0123456789', 'levanc@example.com', 'DaThanhToan', '3',3,3,3,3),
    ('PGH004', '2023-11-23', 'Pham Thi Hien', '0987654321', 'phamthid@example.com', 'ChuaThanhToan', '4',4,4,4,4),
    ('PGH005', '2023-11-24', 'Truong Van Dong', '0123456789', 'truongve@example.com', 'DaThanhToan', '5',5,5,5,5)
	go
--NHANVIEN*************


insert into NHANVIEN_Luong(LuongCoban, LuongTangCa, ThueKhauTru) values
(28000, 30000, null),
(28000, 30000, null),
(30000, 35000, null),
(30000, 35000, null),
(30000, 35000, null)
go
insert into NHANVIEN_ChucVu(TenCV) values
(N'Chủ cửa hàng'),
(N'vệ sinh'),
(N'thu ngân'),
(N'tiếp thị'),
(N'giao hàng')
go
insert into NHANVIEN_CaLam(TenCa) values
(N'1'),
(N'2'),
(N'3'),
(N'4'),
(N'5')
go
insert into NHANVIEN_Anh(AnhURL) values
(N'url1'),
(N'url2'),
(N'url3'),
(N'url4'),
(N'url5')
go
insert into NhanVien values
('nv1', '1999-12-09', N'nv1pass', N'0377187189', 0, N'Phạm Thanh Thủy', N'Hà Nội',0, 1, 1, 1, 1),
('nv2', '1999-12-10', N'nv2pass', N'0316661789', 0, N'Đào Thùy Dương', N'Hà Nội', 0,2, 2, 2, 2),
('nv3', '1999-12-11', N'nv3pass', N'0718819811', 1, N'Bùi Quang Hiếu', N'Hà Nội', 1,3, 3, 3, 3),
('nv4', '1999-12-12', N'nv4pass', N'0991888171', 1, N'Phạm Việt Trọng', N'Hà Nội',1, 4, 4, 4, 4),
('nv5', '1999-12-13', N'nv5pass', N'0566171891', 1, N'Hồ Đức Tài', N'Hà Nội', 0,5, 5, 5, 5)
go
--PGG***********
insert into PhieuGiamGia_TrangThai(TenTrangThai) values
(N'Còn'),
(N'Đã được dùng'),
(N'Đã hết hạn')
go
insert into PhieuGiamGia_MucGiam(TyLeGiam) values
(0.04),
(0.05),
(0.06),
(0.07),
(0.08)
go
insert into PhieuGiamGia_LoaiPhieu(TenLoaiPhieu) values
(N'Giảm giá sản phẩm'),
(N'Giảm giá đơn hàng')
go
insert into PhieuGiamGia_DieuKienApDung(TenDieuKien) values
(N'Trị giá sản phẩm >= 50000'),
(N'Trị giá đơn hàng >= 250000')
go
insert into PhieuGiamGia(MaPhieuGiamGia, MaDieuKien, TrangThai, MaLoaiPhieu, MucGiam, NgayHetHan, MaMucGiam, MaTrangThai) values
('18785976', 1, 1, 1, 6000, '2023-09-30', 1, 1),
('17846981', 1, 1, 1, 7000, '2023-09-30', 1, 1),
('11258974', 2, 1, 2, 8000, '2023-10-01', 1, 1),
('11289756', 2, 1, 2, 9000, '2023-10-02', 1, 1),
('17985648', 1, 1, 1, 10000, '2023-10-03', 1, 1)
go
--banghoadon
INSERT INTO HoaDon (IDKhachHang, MaNhanVien, MaSanPham, MaPhieu, MaPhieuDoi, GiaTri, MaPhieuGiamGia, MaDotGiamGia, SoDT, NgayTao, HinhThucTT,HinhThucNhanHang,TrangThai)
VALUES 
(1, 'nv1', 'Sp001', 'PGH001', '1N6Y8L3F2', 100.5, '11258974', '1D5F9', '0123456789', '2023-11-14', 1,1,1),
(2, 'nv2', 'Sp002', 'PGH002', '4U6W9P2T5', 75.0, '11258974', '3J8K9', '0987654321', '2023-11-14', 1,1,2),
(5, 'nv5', 'Sp005', 'PGH005', '4U6W9P2T5', 90.0, '17846981', '7G4H6', '02620900994', '2023-11-14', 1,1,3);


SELECT SP.MaSanPham, SP.TenSanPham, SUM(HD.GiaTri) AS TongDoanhThu, SP.SoLuong AS TongSoLuong
FROM SanPham SP
LEFT JOIN HoaDon HD ON SP.MaSanPham = HD.MaSanPham
GROUP BY SP.MaSanPham, SP.TenSanPham, SP.SoLuong


SELECT NV.MaNhanVien, NV.HoTen, COUNT(HD.MaNhanVien) AS SoLuongHoaDon, SUM(HD.GiaTri) AS TongDoanhThu, SUM(HD.SoLuong) AS TongSoLuongSanPham
FROM NhanVien NV
LEFT JOIN HoaDon HD ON NV.MaNhanVien = HD.MaNhanVien
GROUP BY NV.MaNhanVien, NV.HoTen

SELECT *
FROM NhanVien NV
LEFT JOIN HoaDon HD ON NV.MaNhanVien = HD.MaNhanVien
GROUP BY NV.MaNhanVien, NV.HoTen