
USE [master]
GO


/****** Object:  Database [TrabajoAnual]    Script Date: 05-Feb-19 2:45:53 PM ******/
CREATE DATABASE [TrabajoAnual]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TrabajoAnual', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\TrabajoAnual.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'TrabajoAnual_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\TrabajoAnual_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO

ALTER DATABASE [TrabajoAnual] SET COMPATIBILITY_LEVEL = 140
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [TrabajoAnual].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [TrabajoAnual] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [TrabajoAnual] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [TrabajoAnual] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [TrabajoAnual] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [TrabajoAnual] SET ARITHABORT OFF 
GO

ALTER DATABASE [TrabajoAnual] SET AUTO_CLOSE ON 
GO

ALTER DATABASE [TrabajoAnual] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [TrabajoAnual] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [TrabajoAnual] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [TrabajoAnual] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [TrabajoAnual] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [TrabajoAnual] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [TrabajoAnual] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [TrabajoAnual] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [TrabajoAnual] SET  ENABLE_BROKER 
GO

ALTER DATABASE [TrabajoAnual] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [TrabajoAnual] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [TrabajoAnual] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [TrabajoAnual] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [TrabajoAnual] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [TrabajoAnual] SET READ_COMMITTED_SNAPSHOT OFF 
GO

ALTER DATABASE [TrabajoAnual] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [TrabajoAnual] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [TrabajoAnual] SET  MULTI_USER 
GO

ALTER DATABASE [TrabajoAnual] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [TrabajoAnual] SET DB_CHAINING OFF 
GO

ALTER DATABASE [TrabajoAnual] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [TrabajoAnual] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO

ALTER DATABASE [TrabajoAnual] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [TrabajoAnual] SET QUERY_STORE = OFF
GO

ALTER DATABASE [TrabajoAnual] SET  READ_WRITE 
GO

USE [TrabajoAnual]
GO

/****** Object:  Table [dbo].[Aerolinea]    Script Date: 04/12/2018 0:22:36 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Aerolinea](
	[ID_Aerolinea] [int] IDENTITY(100,10) NOT NULL,
	[ID_Alianza] [int] NULL,
	[Nombre] [varchar](55) NULL,
	[REF] [varchar](2) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Aerolinea] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Aeropuerto]    Script Date: 04/12/2018 0:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Aeropuerto](
	[ID_Aeropuerto] [char](3) NOT NULL,
	[Ciudad] [varchar](55) NULL,
	[Pais] [int] NULL,
	[Provincia] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Aeropuerto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Alianza]    Script Date: 04/12/2018 0:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Alianza](
	[ID_Alianza] [int] NOT NULL,
	[Nombre] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Alianza] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 04/12/2018 0:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[DNI] [int] NOT NULL,
	[Nombre] [varchar](35) NOT NULL,
	[Apellido] [varchar](30) NOT NULL,
	[CuitCuil] [varchar](15) NOT NULL,
	[FechaNacimiento] [date] NOT NULL,
	[Email] [varchar](40) NOT NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[DNI] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Direccion]    Script Date: 04/12/2018 0:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Direccion](
	[ID_Cliente] [int] NOT NULL,
	[Pais] [int] NULL,
	[Provincia] [int] NULL,
	[Ciudad] [varchar](25) NULL,
	[CodPostal] [varchar](10) NULL,
	[Calle] [varchar](30) NULL,
	[Altura] [varchar](8) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PasajeroFrecuente]    Script Date: 04/12/2018 0:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PasajeroFrecuente](
	[ID_Cliente] [int] NOT NULL,
	[ID_Aerolinea] [int] NULL,
	[Numero] [varchar](15) NULL,
	[Categoria] [varchar](20) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pasaporte]    Script Date: 04/12/2018 0:22:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pasaporte](
	[ID_Cliente] [int] NOT NULL,
	[NumPasaporte] [varchar](15) NULL,
	[AutoridadEmision] [varchar](40) NULL,
	[Pais] [int] NULL,
	[FechaEmision] [date] NULL,
	[FechaVenc] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Cliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Telefono]    Script Date: 04/12/2018 0:22:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Telefono](
	[Cliente_ID] [int] NOT NULL,
	[Personal] [nvarchar](20) NULL,
	[Laboral] [nvarchar](20) NULL,
	[Celular] [nvarchar](20) NULL,
 CONSTRAINT [PK_Telefonos] PRIMARY KEY NONCLUSTERED 
(
	[Cliente_ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ventas]    Script Date: 04/12/2018 0:22:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ventas](
	[ID_Venta] [int] IDENTITY(100,10) NOT NULL,
	[ID_Cliente] [int] NULL,
	[ID_Aerolinea] [int] NULL,
	[ID_Vuelo] [char](7) NULL,
	[FechaHoraVenta] [datetime] NULL,
	[MedioPago] [varchar](15) NULL,
	[Cuotas] [int] NULL,
	[Total] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Venta] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vuelo]    Script Date: 04/12/2018 0:22:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vuelo](
	[ID_Vuelo] [char](7) NOT NULL,
	[ID_Aerolinea] [int] NULL,
	[CantAsientos] [int] NULL,
	[AsientosDisp] [int] NULL,
	[ID_AeropuertoSalida] [char](3) NULL,
	[ID_AeropuertoLlegada] [char](3) NULL,
	[FechaHoraSalida] [datetime] NULL,
	[FechaHoraLlegada] [datetime] NULL,
	[TiempoVuelo] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID_Vuelo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Aerolinea]  WITH CHECK ADD FOREIGN KEY([ID_Alianza])
REFERENCES [dbo].[Alianza] ([ID_Alianza])
GO
ALTER TABLE [dbo].[Direccion]  WITH CHECK ADD  CONSTRAINT [FK__Direccion__ID_Cl__40F9A68C] FOREIGN KEY([ID_Cliente])
REFERENCES [dbo].[Cliente] ([DNI])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Direccion] CHECK CONSTRAINT [FK__Direccion__ID_Cl__40F9A68C]
GO
ALTER TABLE [dbo].[PasajeroFrecuente]  WITH CHECK ADD FOREIGN KEY([ID_Aerolinea])
REFERENCES [dbo].[Aerolinea] ([ID_Aerolinea])
GO
ALTER TABLE [dbo].[PasajeroFrecuente]  WITH CHECK ADD FOREIGN KEY([ID_Cliente])
REFERENCES [dbo].[Cliente] ([DNI])
GO
ALTER TABLE [dbo].[Pasaporte]  WITH CHECK ADD  CONSTRAINT [FK__Pasaporte__ID_Cl__2DE6D218] FOREIGN KEY([ID_Cliente])
REFERENCES [dbo].[Cliente] ([DNI])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Pasaporte] CHECK CONSTRAINT [FK__Pasaporte__ID_Cl__2DE6D218]
GO
ALTER TABLE [dbo].[Telefono]  WITH CHECK ADD  CONSTRAINT [FK_Telefonos_Cliente] FOREIGN KEY([Cliente_ID])
REFERENCES [dbo].[Cliente] ([DNI])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Telefono] CHECK CONSTRAINT [FK_Telefonos_Cliente]
GO
ALTER TABLE [dbo].[Ventas]  WITH CHECK ADD FOREIGN KEY([ID_Aerolinea])
REFERENCES [dbo].[Aerolinea] ([ID_Aerolinea])
GO
ALTER TABLE [dbo].[Ventas]  WITH CHECK ADD FOREIGN KEY([ID_Cliente])
REFERENCES [dbo].[Cliente] ([DNI])
GO
ALTER TABLE [dbo].[Ventas]  WITH CHECK ADD FOREIGN KEY([ID_Vuelo])
REFERENCES [dbo].[Vuelo] ([ID_Vuelo])
GO
ALTER TABLE [dbo].[Vuelo]  WITH CHECK ADD FOREIGN KEY([ID_Aerolinea])
REFERENCES [dbo].[Aerolinea] ([ID_Aerolinea])
GO
ALTER TABLE [dbo].[Vuelo]  WITH CHECK ADD FOREIGN KEY([ID_AeropuertoSalida])
REFERENCES [dbo].[Aeropuerto] ([ID_Aeropuerto])
GO
ALTER TABLE [dbo].[Vuelo]  WITH CHECK ADD FOREIGN KEY([ID_AeropuertoLlegada])
REFERENCES [dbo].[Aeropuerto] ([ID_Aeropuerto])
GO
/****** Object:  StoredProcedure [dbo].[Alta_Vuelo]    Script Date: 04/12/2018 0:22:38 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
--use TrabajoAnual

--create table Alianza (
--	ID_Alianza int primary key,
--	Nombre varchar(20));

--CREATE TABLE [dbo].[Cliente](
--	[DNI] [int] NOT NULL,
--	[Nombre] varchar(35) NOT NULL,
--	[Apellido] varchar(30) NOT NULL,
--	[CuitCuil] varchar(15) NOT NULL,
--	[FechaNacimiento] [date] NOT NULL,
--	[Email] varchar(40) NOT NULL,
-- CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
--(
--	[DNI] ASC
--)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
--) ON [PRIMARY]
--GO

--Create table Direccion (
--	ID_Cliente int primary key foreign key (ID_Cliente)
--	references Cliente(DNI),
--	Pais int,
--	Provincia int,
--	Ciudad varchar(25),
--	CodPostal varchar(10),
--	Calle varchar(30),
--	Altura varchar(8),
--	);

--	Create table Pasaporte (
--	ID_Cliente int primary key foreign key (ID_Cliente)
--	references Cliente(DNI),
--	NumPasaporte varchar(15),
--	AutoridadEmision varchar(40),
--	Pais int,
--	FechaEmision Date,
--	FechaVenc Date);



--Create table PasajeroFrecuente (
--	ID_Cliente int primary key foreign key (ID_Cliente)
--	references Cliente(DNI),
--	ID_Aerolinea int foreign key (ID_Aerolinea)
--	references Aerolinea(ID_Aerolinea),
--	Numero varchar(15),
--	Categoria varchar(20));
   
    
--CREATE TABLE Telefono (Cliente_ID int NOT NULL, Personal nvarchar(20), Laboral nvarchar(20), Celular nvarchar(20),     
--CONSTRAINT PK_Telefonos PRIMARY KEY NONCLUSTERED (Cliente_ID),     
--CONSTRAINT FK_Telefonos_Cliente FOREIGN KEY (Cliente_ID)     
--    REFERENCES Cliente (DNI)     
--    ON DELETE CASCADE    
--);

--DROP TABLE Vuelo;
--DROP TABLE Aeropuerto;
--DROP TABLE Aerolinea;

--create table Aerolinea(
--	ID_Aerolinea int primary key (ID_Aerolinea) identity (100,10),
--	ID_Alianza int foreign key (ID_Alianza)
--	references Alianza(ID_Alianza),
--	Nombre varchar(55),
--	REF varchar(2)	
--);

--create table Aeropuerto(
--	ID_Aeropuerto char(3) primary key (ID_Aeropuerto) NOT NULL,
--	Ciudad varchar(55),
--	Pais int,
--	Provincia int);


--CREATE TABLE Vuelo 
--	(ID_Vuelo char(7) PRIMARY KEY,
--	ID_Aerolinea int FOREIGN KEY (ID_Aerolinea)	references Aerolinea(ID_Aerolinea),
--	CantAsientos int,
--	AsientosDisp int,
--	ID_AeropuertoSalida char(3) FOREIGN KEY (ID_AeropuertoSalida)	references Aeropuerto(ID_Aeropuerto),
--	ID_AeropuertoLlegada char(3) FOREIGN KEY (ID_AeropuertoLlegada) references Aeropuerto(ID_Aeropuerto),
--	FechaHoraSalida DATETIME,
--	FechaHoraLlegada DATETIME,
--	TiempoVuelo varchar(15))


--EXEC Alta_Vuelo 4230,13,2,'DEN','LAS','2010-10-23T12:45:00','1968-10-23T15:15:17.000','23 hs'
--EXEC Alta_Vuelo ?,?,?,?,?,?,?,?


CREATE PROCEDURE [dbo].[Alta_Vuelo] 
	@ID_Aerolinea int ,
	@CantAsientos int ,
	@AsientosDisp int ,
	@ID_AeropuertoSalida char(3),
	@ID_AeropuertoLlegada char(3),
	@FechaHoraSalida datetime,
	@FechaHoraLlegada datetime,
	@TiempoVuelo varchar(15)
AS
BEGIN
	DECLARE @iniciales varchar(8)
	DECLARE @cant int
	
	SELECT @iniciales = REF FROM Aerolinea WHERE ID_Aerolinea=@ID_Aerolinea;
	SELECT @cant=COUNT(v.ID_Vuelo) FROM Vuelo v WHERE ID_Vuelo LIKE CONCAT(@iniciales,'%');

	INSERT INTO Vuelo VALUES  
	(CONCAT(@iniciales,'-', right('000' +Convert(varchar(4),@cant+1),4)), @ID_Aerolinea, @CantAsientos, @AsientosDisp, @ID_AeropuertoSalida, @ID_AeropuertoLlegada
	,@FechaHoraSalida,@FechaHoraLlegada,@TiempoVuelo);
END
GO


INSERT [dbo].[Alianza] ([ID_Alianza], [Nombre]) VALUES (1, N'Skyteam')
INSERT [dbo].[Alianza] ([ID_Alianza], [Nombre]) VALUES (2, N'One World')
INSERT [dbo].[Alianza] ([ID_Alianza], [Nombre]) VALUES (3, N'Star Alliance')

SET IDENTITY_INSERT [dbo].[Aerolinea] ON 

INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (560, 1, N'Air Berlin', N'AB')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (570, 1, N'Niki', N'NI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (580, 1, N'American Airlines', N'AA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (590, 1, N'American Eagle', N'AE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (600, 1, N'US Airways', N'UA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (610, 1, N'US Airways Express', N'UI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (620, 1, N'US Airways Shuttle', N'UR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (630, 1, N'British Airways', N'BA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (640, 1, N'BA CityFlyer', N'BC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (650, 1, N'British Airways Limited', N'BI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (660, 1, N'Comair', N'CO')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (670, 1, N'OpenSkies', N'OP')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (680, 1, N'Sun', N'SU')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (690, 1, N'Cathay Pacific', N'CP')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (700, 1, N'Dragonair', N'DR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (710, 1, N'Finnair', N'FI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (720, 3, N'Nordic Regional Airlines', N'NR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (730, 1, N'Iberia', N'IB')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (740, 1, N'Air Nostrum', N'AN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (750, 1, N'Iberia Express', N'IE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (760, 1, N'Iberia Regional', N'IR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (770, 1, N'Japan Airlines', N'JA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (780, 1, N'Japan Transocean Air', N'JT')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (790, 1, N'LAN Airlines', N'LA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (800, 1, N'LAN Argentina', N'LR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (810, 1, N'LAN Ecuador', N'LE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (820, 1, N'LAN Express', N'LX')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (830, 1, N'LAN Peru', N'LP')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (840, 1, N'LAN Colombia', N'LC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (850, 1, N'Malaysia Airlines', N'MA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (860, 1, N'Qantas', N'QA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (870, 1, N'Jetconnect', N'JE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (880, 1, N'QantasLink', N'QN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (890, 1, N'Qatar Airways', N'QI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (900, 1, N'Royal Jordanian', N'RJ')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (910, 1, N'S7 Airlines', N'SA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (920, 1, N'Globus Airlines', N'GA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (940, 1, N'TAM Airlines', N'TA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (950, 1, N'Aer Lingus', N'AL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (960, 1, N'Air Tahiti Nui', N'AT')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (970, 1, N'Interjet', N'IN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (980, 1, N'Royal Air Maroc', N'RA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (990, 1, N'TAM Paraguay', N'TP')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1000, 2, N'Aeroflot', N'AR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1010, 2, N'Aerolíneas Argentinas', N'AG')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1020, 2, N'Austral Líneas Aéreas', N'AÍ')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1030, 2, N'Aeromexico', N'AO')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1040, 2, N'Aeroméxico Connect', N'AC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1050, 2, N'Air Europa', N'AU')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1060, 2, N'Air France', N'AF')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1070, 2, N'Alitalia', N'AI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1080, 2, N'China Airlines', N'CA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1090, 2, N'Mandarin Airlines', N'MI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1100, 2, N'China Eastern Airlines', N'CE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1110, 2, N'Shanghai Airlines', N'SR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1120, 2, N'China Southern Airlines', N'CS')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1130, 2, N'Czech Airlines', N'CI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1140, 2, N'Delta Air Lines', N'DA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1150, 2, N'Delta Connection', N'DC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1160, 2, N'Delta Shuttle', N'DS')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1170, 2, N'Garuda Indonesia', N'GI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1180, 2, N'Kenya Airways', N'KA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1190, 2, N'KLM', N'KL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1200, 2, N'KLM Cityhopper', N'KC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1210, 2, N'Korean Air', N'KI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1220, 2, N'Middle East Airlines', N'ME')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1230, 2, N'Saudia', N'SD')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1240, 2, N'TAROM', N'TR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1250, 2, N'Vietnam Airlines', N'VA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1260, 2, N'Xiamen Airlines', N'XA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1270, 2, N'Air Madagascar', N'AM')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1280, 2, N'Air Mauritius', N'AS')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1290, 2, N'Gol Transportes Aéreos', N'GT')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1300, 2, N'Hunnu Air', N'HA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1310, 2, N'Uzbekistan Airways', N'UW')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1320, 2, N'Virgin Atlantic', N'VT')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1330, 3, N'Adria Airways', N'AW')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1340, 3, N'Aegean Airlines', N'EA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1350, 3, N'Olympic Air', N'OA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1360, 3, N'Air Canada', N'AD')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1370, 3, N'Air Canada Express', N'IC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1380, 3, N'Air Canada Rouge', N'IA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1390, 3, N'Air China', N'AH')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1400, 3, N'Dalian Airlines', N'DI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1410, 3, N'Air India', N'II')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1420, 3, N'Air India Regional', N'ID')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1430, 3, N'Air New Zealand', N'IW')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1440, 3, N'Air New Zealand Link', N'RN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1450, 3, N'All Nippon Airways', N'AP')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1460, 3, N'Asiana Airlines', N'SL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1470, 3, N'Austrian Airlines', N'UL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1480, 3, N'Avianca', N'AV')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1490, 3, N'Avianca Brazil', N'AZ')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1500, 3, N'Avianca Costa Rica', N'VC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1510, 3, N'Avianca Ecuador', N'VE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1530, 3, N'Avianca Guatemala', N'VG')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1540, 3, N'Avianca Honduras', N'VH')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1550, 3, N'Avianca Nicaragua', N'VN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1560, 3, N'Avianca Peru', N'VP')
GO
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1570, 3, N'Brussels Airlines', N'BR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1580, 3, N'Copa Airlines', N'CR')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1590, 3, N'Copa Airlines Colombia', N'CL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1600, 3, N'Croatia Airlines', N'CN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1610, 3, N'EgyptAir', N'EG')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1620, 3, N'EgyptAir Express', N'EE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1630, 3, N'Air Sinai', N'IS')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1640, 3, N'Ethiopian Airlines', N'EI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1650, 3, N'EVA Air', N'ER')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1660, 3, N'Uni Air', N'NA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1670, 3, N'LOT Polish Airlines', N'LO')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1680, 3, N'Lufthansa', N'LU')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1690, 3, N'Air Dolomiti', N'IO')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1700, 3, N'Lufthansa CityLine', N'LI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1710, 3, N'Lufthansa Regional', N'LG')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1720, 3, N'Scandinavian Airlines', N'SN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1730, 3, N'Blue1', N'BL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1740, 3, N'Shenzhen Airlines', N'SE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1750, 3, N'Singapore Airlines', N'SS')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1760, 3, N'South African Airways', N'SF')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1770, 3, N'Airlink', N'IL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1780, 3, N'Mango', N'MN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1790, 3, N'South African Express', N'SC')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1800, 3, N'SWISS International Air Lines', N'ST')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1810, 3, N'Edelweiss Air', N'WA')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1820, 3, N'Swiss Global Air Lines', N'SG')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1830, 3, N'TAP Portugal', N'TO')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1840, 3, N'PGA Express', N'PE')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1850, 3, N'Portugalia', N'PO')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1860, 3, N'Thai Airways International', N'TI')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1870, 3, N'Turkish Airlines', N'TL')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1880, 3, N'Anadolu Jet', N'AJ')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1890, 3, N'Turkey Sun Express', N'TS')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1900, 3, N'United Airlines', N'UN')
INSERT [dbo].[Aerolinea] ([ID_Aerolinea], [ID_Alianza], [Nombre], [REF]) VALUES (1910, 3, N'United Express', N'UE')
SET IDENTITY_INSERT [dbo].[Aerolinea] OFF
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ABD', N'ABADAN', 84, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ABJ', N'ABIDJAN', 46, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ABU', N'ABU DHABI', 55, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ACA', N'ACAPULCO', 117, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ACC', N'ACCRA', 70, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ADD', N'ADDIS', 62, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ADL', N'ADELAIDE', 11, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AFA', N'SAN RAFAEL', 9, 12)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AGP', N'MALAGA', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AJU', N'ARACAJU', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AKL', N'AUCKLAND', 131, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ALG', N'ARGEL', 8, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ALP', N'ALEPRO', 164, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ALY', N'ALEJANDRIA', 53, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AMM', N'AMMAN', 93, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AMS', N'AMSTERDAM', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ANC', N'ANCHORAGE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ANF', N'ANTOFAGASTA', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ANK', N'ANKARA', 182, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ANU', N'ANTIGUA', 6, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AOL', N'PASO DE LOS LIBRES', 9, 6)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'APW', N'APIA', 153, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'APZ', N'ZAPALA', 9, 14)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AQP', N'AREQUIPA', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ARI', N'ARICA', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ARR', N'ALTO RIO SENGUERR', 9, 4)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ASM', N'ASMARA', 62, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ASU', N'ASUNCION', 138, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ATH', N'ATENAS', 72, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ATL', N'ATLANTA', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AUA', N'ARUBA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'AYP', N'AYACUCHO', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BAH', N'BAHREIN', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BAQ', N'BARRANQUILLA', 42, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BBA', N'BALMACEDA', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BCN', N'BARCELONA', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BDL', N'HARTFORD', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BEG', N'BELGRADO', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BEI', N'BEIRUT', 102, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BEL', N'BELEM', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BEN', N'BENGHAZI', 104, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BER', N'BERLIN', 3, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BGF', N'BANGUI', 143, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BGI', N'BARBADOS', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BGO', N'BERGEN', 130, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BGW', N'BAGDAD', 83, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BHI', N'BAHIA BLANCA', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BHZ', N'BELO HORIZONTE', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BIO', N'BILBAO', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BJL', N'BANJUL', 68, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BJM', N'BUJUMBURA', 30, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BKI', N'KOTA KINABALU', 109, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BKK', N'BANGKOK', 173, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BKO', N'BAMAKO', 112, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BKY', N'BUKAVU', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BLA', N'BARCELONA', 189, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BLQ', N'BOLOGNA', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BLR', N'BOLIVAR', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BLZ', N'BLANTYRE', 110, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BNA', N'NASHVILLE', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BNE', N'BRISBANE', 11, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BNF', N'BUFFALO', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BOG', N'BOGOTA', 42, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BOM', N'BOMBAY', 81, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BON', N'BONAIRE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BOS', N'BOSTON', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BRC', N'BARILOCHE', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BRU', N'BRUSELAS', 18, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BSB', N'BRASILIA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BSR', N'BASRA', 83, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BTS', N'BRATISLAVA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BUD', N'BUDAPEST', 80, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BUE', N'BUENOS AIRES', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BUH', N'BUCAREST', 151, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BUQ', N'BULAWAYO', 194, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BWI', N'BALTIMORE', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BWN', N'BEGAWAN', 27, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'BZV', N'BRAZZAVILLE', 147, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CAI', N'EL CAIRO', 53, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CAN', N'GUANGZHOU', 39, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CAS', N'CASABLANCA', 114, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CAT', N'CATANIA', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CAY', N'CAYENA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CBB', N'COCHABAMBA', 23, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CCP', N'CONCEPCION', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CCS', N'CARACAS', 189, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CCU', N'CALCUTA', 81, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CEB', N'CEBU', 63, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CGB', N'CUIABA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CGN', N'COLONIA', 3, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CHC', N'CHRISTCHURCH', 131, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CHI', N'CHICAGO', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CHM', N'CHOS MALAL', 9, 14)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CHS', N'LAS HERAS', 9, 12)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CIX', N'CHICLAYO', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CJC', N'CALAMA', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CKY', N'CONAKRI', 75, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CLE', N'CLEVELAND', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CLF', N'EL CALAFATE', 9, 19)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CLO', N'CALI', 42, 0)
GO
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CLT', N'COLONIA CATRIEL', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CMB', N'COLOMBO', 166, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CMH', N'COLUMBUS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CNQ', N'CORRIENTES', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CNS', N'CAIRNS', 11, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'COC', N'CONCORDIA', 9, 7)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'COO', N'COTONOU', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'COR', N'CORDOBA', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CPC', N'CHAPELCO', 9, 14)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CPH', N'COPENHAGUE', 50, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CPO', N'COPIAPO', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CPT', N'CAPE TOWN', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CRD', N'COMODORO RIVADAVIA', 9, 4)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CSU', N'CORONEL SUAREZ', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CTC', N'CATAMARCA', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CTG', N'CARTAGENA', 42, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CUN', N'CANCUN', 117, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CUR', N'CURACAO', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CUT', N'CUTRAL CO', 9, 14)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CUZ', N'CUZCO', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CVG', N'CINCINNATI', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CVH', N'CAVIAHUE', 9, 14)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CWB', N'CURITIBA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CYL', N'CAYO LARGO', 49, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'CYR', N'COLONIA', 186, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DAC', N'DHAKA', 15, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DAM', N'DAMASCO', 164, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DAR', N'DAR ES SALAAM', 174, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DAY', N'DAYTON', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DBV', N'DUBROVNIK', 48, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DEL', N'DELHI', 81, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DEN', N'DENVER', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DFW', N'DALLAS/FORT WORTH', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DHA', N'DHAHRAN', 7, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DIR', N'DIRE DAWA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DKR', N'DAKAR', 159, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DLA', N'DOUALA', 34, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DLC', N'DALIAN', 39, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DOH', N'DOHA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DPS', N'DENPASAR BALI', 82, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DRY', N'PUERTO MADRYN', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DTT', N'DETROI', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DUB', N'DUBLIN', 85, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DUS', N'DUSSELDORF', 3, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'DXB', N'DUBAI', 55, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'EBB', N'ENTEBE', 185, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ECL', N'EL CHALTEN', 9, 19)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'EHL', N'EL BOLSON', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'EMX', N'EL MAITEN', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'EQS', N'ESQUEL', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ESR', N'EL SALVADOR', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FAO', N'FARO', 141, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FBM', N'LUBUMBASHI', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FDF', N'FORT DE FRANCE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FIH', N'KINSHASA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FLL', N'FORT LAUDERDALE', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FLN', N'FLORIANOPOLIS', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FMA', N'FORMOSA', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FNA', N'FREETOWN', 162, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FNC', N'FUNCHAL', 141, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FOR', N'FORTALEZA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FRA', N'FRANKFURT', 3, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'FUK', N'FUKUOKA', 92, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GBE', N'GABORONE', 25, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GEO', N'GEORGETOWN', 74, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GGS', N'GOBERNADOR GREGORES', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GIB', N'GIBRALTAR', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GNR', N'GENERAL ROCA', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GOA', N'GENOVA', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GOT', N'GOTEMBURGO', 170, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GPO', N'GENERAL PICO', 9, 10)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GRZ', N'GRAZ', 12, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GUA', N'GUATEMALA', 73, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GUM', N'GUAM', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GVA', N'GINEBRA', 171, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GYE', N'GUAYAQUIL', 52, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'GYN', N'GOIANIA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HAM', N'HAMBURGO', 3, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HAN', N'HANOI', 190, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HAV', N'HABANA', 49, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HEL', N'HELSINKI', 64, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HKG', N'HONG KONG', 39, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HKT', N'PHUKET', 173, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HNL', N'HONOLULU ( HAWAII )', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HOR', N'HORTA', 141, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HOU', N'HOUSTON', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'HRE', N'HARARE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IGR', N'IGUAZU', 9, 13)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IGU', N'IGUACU', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IJC', N'INGENIERO JACOBACCI', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IND', N'INDIANAPOLIS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ING', N'LAGO ARGENTINO', 9, 19)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IPC', N'ISLA DE PASCUA', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IQQ', N'IQUIQUE', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IQT', N'IQUITOS', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IRJ', N'LA RIOJA', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ISB', N'ISLAMABAD', 82, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IST', N'ESTAMBUL', 182, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IUE', N'NIUE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'IZM', N'ESMIRNA', 182, 0)
GO
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'JED', N'JEDDAH', 7, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'JNB', N'JOHANNESBURGO', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'JPA', N'JOAO PESSOA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'JRS', N'JERUSALEM', 89, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'JSM', N'JOSE DE SAN MARTIN', 9, 4)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'JUJ', N'JUJUY', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'JUL', N'KUALA LUMPUR', 109, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KAN', N'KANO', 129, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KBL', N'KABUL', 1, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KGL', N'KIGALI', 150, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KHH', N'KAOHSIUNG', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KHI', N'KARACHI', 134, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KIN', N'KINGSTON', 91, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KLU', N'KLAGENFURT', 12, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KNA', N'VIÑA DEL MAR', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KRS', N'KRISTIANSAND', 130, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KRT', N'KHARTUM', 168, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KTM', N'KATMANDU', 126, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'KWI', N'KUWAIT', 98, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LAD', N'LUANDA', 5, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LAS', N'LAS VEGAS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LAX', N'LOS ANGELES', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LBV', N'LIBREVILLE', 67, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LCA', N'LARNACA', 40, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LCE', N'LA CEIBA', 79, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LCG', N'LA CORUÑA', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LCP', N'LONCOPUE', 9, 14)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LFW', N'LOME', 177, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LIL', N'LILLE', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LIM', N'LIMA', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LIS', N'LISBOA', 141, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LJU', N'LJUBLJANA', 58, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LLW', N'LILONGWE', 110, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LNZ', N'LINZ', 12, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LON', N'LONDRES', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LOS', N'LAGOS', 129, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LPA', N'LAS PALMAS', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LPB', N'LA PAZ', 23, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LPG', N'LA PLATA', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LSC', N'LA SERENA', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LSQ', N'LOS ANGELES', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LUN', N'LUSAKA', 193, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LUQ', N'SAN LUIS', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LUX', N'LUXEMBURGO', 107, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'LYS', N'LYON', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MAA', N'MADRAS', 81, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MAD', N'MADRID', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MAO', N'MANAOS', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MAR', N'MARACAIBO', 189, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MBJ', N'MONTEGO BAY', 91, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MCP', N'MACAPA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MCT', N'MASCATE', 132, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MCZ', N'MACEIO', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MDQ', N'MAR DEL PLATA', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MDZ', N'MENDOZA', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MEL', N'MELBOURNE', 11, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MEM', N'MENPHIS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MEX', N'MEXICO', 117, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MGA', N'MANAGUA', 127, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MIA', N'MIAMI', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MID', N'MERIDA', 117, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MIL', N'MILAN', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MKC', N'KANSAS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MKE', N'MILWAUKEE WISC', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MLA', N'MALTA', 113, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MLG', N'MALARGUE', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MLH', N'MULHOUSE', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MLW', N'MONROVIA', 103, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MMA', N'MALMO', 170, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MNL', N'MANILA', 63, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MOW', N'MOSCU', 152, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MPM', N'MAPUTO', 123, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MRS', N'MARSELLA', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MRU', N'MAURICIO', 42, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MSP', N'MINNEAPOLIS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MSY', N'NUEVA ORLEANS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MUC', N'MUNICH', 3, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'MVD', N'MONTEVIDEO', 186, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NAN', N'NADI', 65, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NAP', N'NAPOLES', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NAS', N'NASSAU', 14, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NAT', N'NATAL', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NCE', N'NIZA', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NDJ', N'NDJAMENA', 37, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NDL', N'TANDIL', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NEC', N'NECOCHEA', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NGO', N'NAGOYA', 92, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NIC', N'NICOSIA', 40, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NIM', N'NIAMEI', 129, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NKC', N'NOUAKCHOTT', 116, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NOU', N'NOUMEA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NQN', N'NEUQUEN', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'NYC', N'NUEVA YORK', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ODS', N'ODESSA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OEL', N'CHOELE CHOEL', 9, 14)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OES', N'SAN ANTONIO OESTE', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OKA', N'OKINAWA', 92, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OLC', N'OLAVARRIA', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OPO', N'OPORTO', 141, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ORF', N'NORFOLK', 60, 0)
GO
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ORL', N'ORLANDO', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OSA', N'OSAKA', 92, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OSL', N'OSLO', 130, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'OYA', N'GOYA', 9, 6)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PAJ', N'PINAMAR', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PAP', N'PORT AU PRINCE', 78, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PAR', N'PARIS', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PBM', N'PARAMARIBO', 172, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PCL', N'PUCALLPA', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PDL', N'PONTA DELGADA', 141, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PDP', N'PUNTA DEL ESTE', 186, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PDX', N'PORTLAND', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PEK', N'PEKIN', 39, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PEM', N'PUERTO MALDONADO', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PEN', N'PENANG', 109, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PER', N'PERTH', 11, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PHL', N'FILADELFIA', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PHX', N'PHOENIX', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PIT', N'PITTSBURG', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PIU', N'PIURA', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PMC', N'PUERTO MONTT', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PMI', N'P. DE MALLORCA', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PMO', N'PALERMO', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PMQ', N'PERITO MORENO', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PMV', N'PORLAMAR', 189, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'POA', N'PORTO ALEGRE', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'POS', N'PORT OF SPAIN', 179, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PPG', N'PAGO PAGO', 153, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PPT', N'PAPEETE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PRA', N'PARANA', 9, 7)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PRG', N'PRAGA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PSS', N'POSADAS', 9, 13)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PTP', N'POINTE A PITRE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PTY', N'PANAMA', 136, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PUD', N'PUERTO DESEADO', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PUJ', N'PUNTA CANA', 148, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PUQ', N'PUNTA ARENAS', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'PXO', N'PORTO SANTO', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RAR', N'RARO178', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RCQ', N'RECONQUISTA', 9, 20)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RCU', N'RIO CUARTO', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RDU', N'RALEIGH', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'REC', N'RECIFE', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'REG', N'REGGIO CALABRIA', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'REK', N'REYKJAVIK', 86, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'REL', N'TRELEW', 9, 4)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RES', N'RESISTENCIA', 9, 3)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RGA', N'RIO GRANDE', 9, 22)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RGL', N'RIO GALLEGOS', 9, 19)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RGN', N'RANGOON', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RIC', N'RICHMOND', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RIO', N'RIO DE JANEIRO', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RNS', N'RINCON DE LOS SAUCES', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ROC', N'ROCHESTER', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ROM', N'ROMA', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ROS', N'ROSARIO', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ROY', N'RIO MAYO', 9, 4)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RSA', N'SANTA ROSA', 9, 10)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RTB', N'ROATAN', 79, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RUH', N'RIYADH', 7, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RUN', N'SAINT DENIS', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RYO', N'RIO TURBIO', 9, 19)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'RZA', N'SANTA CRUZ', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SAH', N'SANAA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SAL', N'SAN SALVADOR', 54, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SAN', N'SAN DIEGO', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SAO', N'SAO PAULO', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SAP', N'SAN PEDRO SULA', 79, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SCL', N'SANTIAGO DE 38', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SCQ', N'SANTIAGO DE COMPOSTELA', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SDE', N'SANTIAGO DEL ESTERO', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SDQ', N'SANTO DOMINGO', 148, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SEA', N'SEATTLE', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SEL', N'SEUL', 45, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SFN', N'SANTA FE', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SFO', N'SAN FRANCISCO', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SGN', N'HO CHI MINH', 190, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SGV', N'SIERRA GRANDE', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SHA', N'SHANGHAI', 39, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SHJ', N'SHARJAH', 55, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SID', N'ILHA DO SAL', 32, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SIN', N'SINGAPUR', 163, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SJC', N'SAN JOSE CALIFORNIA', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SJO', N'SAN JOSE', 47, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SJU', N'SAN JUAN', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SKG', N'TESALONICA', 72, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SLA', N'SALTA', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SLC', N'SALT LAKE CITY', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SLU', N'ST LUCIA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SLZ', N'SAO LUIZ', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SMR', N'SANTA MARTA', 42, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SNN', N'SHANNON', 85, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SOF', N'SOFIA', 28, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SPN', N'SAIPAN', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SRZ', N'SANTA CRUZ', 23, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SSA', N'SALVADOR', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SST', N'SANTA TERESITA', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ST ', N'ST. CROIX', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'STL', N'ST. LOUIS', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'STO', N'ESTOCOLMO', 170, 0)
GO
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'STR', N'STUTTGART', 3, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'STT', N'ST. THOMAS', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SUF', N'LAMEZIA TERME', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SVG', N'STAVANGER', 130, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SVQ', N'SEVILLA', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SXB', N'ESTRASBURGO', 66, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SXM', N'ST. MAARTEN', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SYD', N'SYDNEY', 11, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'SZG', N'SALZBURGO', 12, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TBT', N'TABATINGA', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TBU', N'TONGATAPU', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TCI', N'TENERIFE', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TCQ', N'TACNA', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TER', N'TERCEIRA', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TFF', N'TEFE', 26, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TGU', N'TEGUCIGALPA', 79, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'THR', N'TEHERAN', 84, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TIA', N'TIRANA', 2, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TIP', N'TRIPOLI', 104, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TJA', N'TARIJA', 23, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TLV', N'TEL AVIV', 89, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TNG', N'TANGER', 114, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TNR', N'ANTANANARIVO', 108, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TPA', N'TAMPA', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TPE', N'TAIPEI', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TRN', N'TURIN', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TRU', N'TRUJILLO', 139, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TSR', N'TIMISOALA', 151, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TUC', N'TUCUMAN', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TUN', N'TUNEZ', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TUS', N'TUCSON', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'TYO', N'TOKYO', 92, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'UAQ', N'SAN JUAN', 9, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'UIO', N'QUITO', 52, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ULA', N'SAN JULIAN', 9, 19)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'USH', N'USHUAIA', 9, 22)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VCE', N'VENECIA', 90, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VDM', N'VIEDMA', 9, 15)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VFA', N'VICTORIA FALLS', 194, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VGO', N'VIGO', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VIE', N'VIENA', 12, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VLC', N'VALENCIA', 59, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VLG', N'VILLA GESELL', 9, 1)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VME', N'VILLA MERCEDES', 9, 18)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VNO', N'VILNA', 106, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'VRA', N'VARADERO', 49, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'WAS', N'WASHINGTON D. C.', 60, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'WAW', N'VARSOVIA', 140, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'WDH', N'WINDHOEK', 124, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'WLG', N'WELLINGTON', 131, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'XMN', N'XIAMEN', 0, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YEG', N'EDMONTON', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YOG', N'WINDSOR', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YOW', N'OTTAWA', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YUL', N'MONTREAL', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YVR', N'VANCOUVER', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YWG', N'WINNIPEG', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YYC', N'CALGARY', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YYJ', N'VICTORIA', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'YYZ', N'TORONTO', 35, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ZAG', N'ZAGREB', 48, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ZAL', N'VALDIVIA', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ZCO', N'TEMUCO', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ZOS', N'OSORNO', 38, 0)
INSERT [dbo].[Aeropuerto] ([ID_Aeropuerto], [Ciudad], [Pais], [Provincia]) VALUES (N'ZRH', N'ZURICH', 171, 0)
INSERT [dbo].[Cliente] ([DNI], [Nombre], [Apellido], [CuitCuil], [FechaNacimiento], [Email]) VALUES (4064852, N'Agustin', N'Castro', N'27-40648652-2', CAST(N'1997-08-07' AS Date), N'agustin.castro2011@gmail.com')
INSERT [dbo].[Cliente] ([DNI], [Nombre], [Apellido], [CuitCuil], [FechaNacimiento], [Email]) VALUES (21667940, N'Veronica', N'Ibarra', N'22-21667940-5', CAST(N'1970-11-18' AS Date), N'veronicab.ibarra@hotmail.com.ar')
INSERT [dbo].[Cliente] ([DNI], [Nombre], [Apellido], [CuitCuil], [FechaNacimiento], [Email]) VALUES (21980808, N'Pablo', N'Castro', N'25-21980808-6', CAST(N'1970-12-27' AS Date), N'pablo.castro2003@gmail.com')
INSERT [dbo].[Direccion] ([ID_Cliente], [Pais], [Provincia], [Ciudad], [CodPostal], [Calle], [Altura]) VALUES (4064852, 9, 1, N'Pilar', N'1629', N'Fragata Heroina', N'1604')
INSERT [dbo].[Direccion] ([ID_Cliente], [Pais], [Provincia], [Ciudad], [CodPostal], [Calle], [Altura]) VALUES (21667940, 13, -1, N'Chubut', N'2589', N'Frag Heroin', N'4061')
INSERT [dbo].[Direccion] ([ID_Cliente], [Pais], [Provincia], [Ciudad], [CodPostal], [Calle], [Altura]) VALUES (21980808, 9, 22, N'Pilar', N'1629', N'Fragata Heroina', N'1604')
INSERT [dbo].[PasajeroFrecuente] ([ID_Cliente], [ID_Aerolinea], [Numero], [Categoria]) VALUES (4064852, 980, N'40648652', N'VIP')
INSERT [dbo].[PasajeroFrecuente] ([ID_Cliente], [ID_Aerolinea], [Numero], [Categoria]) VALUES (21667940, 840, N'21685243', N'Madre')
INSERT [dbo].[PasajeroFrecuente] ([ID_Cliente], [ID_Aerolinea], [Numero], [Categoria]) VALUES (21980808, 1860, N'21980808', N'Normal')
INSERT [dbo].[Pasaporte] ([ID_Cliente], [NumPasaporte], [AutoridadEmision], [Pais], [FechaEmision], [FechaVenc]) VALUES (4064852, N'40648652', N'Pablo', 4, CAST(N'2017-05-13' AS Date), CAST(N'2019-04-19' AS Date))
INSERT [dbo].[Pasaporte] ([ID_Cliente], [NumPasaporte], [AutoridadEmision], [Pais], [FechaEmision], [FechaVenc]) VALUES (21667940, N'21667940', N'Scyula', 9, CAST(N'2016-12-03' AS Date), CAST(N'2018-12-08' AS Date))
INSERT [dbo].[Pasaporte] ([ID_Cliente], [NumPasaporte], [AutoridadEmision], [Pais], [FechaEmision], [FechaVenc]) VALUES (21980808, N'21980808', N'Scyula', -1, CAST(N'2017-10-11' AS Date), CAST(N'2020-12-26' AS Date))
INSERT [dbo].[Telefono] ([Cliente_ID], [Personal], [Laboral], [Celular]) VALUES (4064852, N'11-4035-0841', N'', N'')
INSERT [dbo].[Telefono] ([Cliente_ID], [Personal], [Laboral], [Celular]) VALUES (21667940, N'11-5928-3536', N'-', N'-')
INSERT [dbo].[Telefono] ([Cliente_ID], [Personal], [Laboral], [Celular]) VALUES (21980808, N'1140803269', N'', N'')

INSERT [dbo].[Vuelo] ([ID_Vuelo], [ID_Aerolinea], [CantAsientos], [AsientosDisp], [ID_AeropuertoSalida], [ID_AeropuertoLlegada], [FechaHoraSalida], [FechaHoraLlegada], [TiempoVuelo]) VALUES (N'LR-0001', 800, 12, 11, N'AFA', N'ABU', CAST(N'2018-12-07 09:05:00.000' AS DateTime), CAST(N'2018-12-07 18:20:33.943' AS DateTime), N'4hs')
INSERT [dbo].[Vuelo] ([ID_Vuelo], [ID_Aerolinea], [CantAsientos], [AsientosDisp], [ID_AeropuertoSalida], [ID_AeropuertoLlegada], [FechaHoraSalida], [FechaHoraLlegada], [TiempoVuelo]) VALUES (N'NI-0001', 570, 2, 1, N'CTC', N'BUE', CAST(N'2018-12-06 17:00:00.000' AS DateTime), CAST(N'2018-12-06 19:05:11.870' AS DateTime), N'1 hora')

SET IDENTITY_INSERT [dbo].[Ventas] ON 

INSERT [dbo].[Ventas] ([ID_Venta], [ID_Cliente], [ID_Aerolinea], [ID_Vuelo], [FechaHoraVenta], [MedioPago], [Cuotas], [Total]) VALUES (110, 4064852, 570, N'NI-0001', CAST(N'2018-12-05 17:57:29.993' AS DateTime), N'Efectivo', 1, 1500)
SET IDENTITY_INSERT [dbo].[Ventas] OFF
/****** Object:  Index [PK_Telefonos]    Script Date: 5/2/2019 18:34:17 ******/
