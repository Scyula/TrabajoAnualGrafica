
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
