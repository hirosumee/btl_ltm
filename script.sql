USE [database_chat_realtime_app]
GO
/****** Object:  Table [dbo].[File]    Script Date: 29-Sep-19 9:29:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[File](
	[id] [int] NOT NULL,
	[name] [nchar](255) NULL,
	[size] [int] NULL,
	[time] [date] NULL,
	[id_messfile] [int] NULL,
	[mimetype] [nchar](10) NULL,
	[file_path] [nchar](255) NULL,
 CONSTRAINT [PK_File] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Joint]    Script Date: 29-Sep-19 9:29:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Joint](
	[id] [int] NOT NULL,
	[fk_username] [nchar](255) NULL,
	[time] [date] NULL,
	[id_room] [int] NULL,
	[adder] [nchar](255) NULL,
 CONSTRAINT [PK_Joint] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MessFile]    Script Date: 29-Sep-19 9:29:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MessFile](
	[id] [int] NOT NULL,
	[id_joint] [int] NULL,
	[time] [date] NULL,
 CONSTRAINT [PK_MessFile] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MessText]    Script Date: 29-Sep-19 9:29:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MessText](
	[id] [int] NOT NULL,
	[id_joint] [int] NULL,
	[content] [nchar](4000) NULL,
	[time] [date] NULL,
 CONSTRAINT [PK_MessText] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 29-Sep-19 9:29:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[id] [int] NOT NULL,
	[group_IP] [nchar](15) NULL,
	[type] [nchar](10) NULL,
	[creator] [nchar](255) NOT NULL,
	[time] [date] NULL,
	[update_time] [date] NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 29-Sep-19 9:29:50 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[username] [nchar](255) NOT NULL,
	[pass] [nchar](255) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[File]  WITH CHECK ADD  CONSTRAINT [FK_File_MessFile] FOREIGN KEY([id_messfile])
REFERENCES [dbo].[MessFile] ([id])
GO
ALTER TABLE [dbo].[File] CHECK CONSTRAINT [FK_File_MessFile]
GO
ALTER TABLE [dbo].[Joint]  WITH CHECK ADD  CONSTRAINT [FK_Joint_Room] FOREIGN KEY([id_room])
REFERENCES [dbo].[Room] ([id])
GO
ALTER TABLE [dbo].[Joint] CHECK CONSTRAINT [FK_Joint_Room]
GO
ALTER TABLE [dbo].[Joint]  WITH CHECK ADD  CONSTRAINT [FK_Joint_User] FOREIGN KEY([fk_username])
REFERENCES [dbo].[User] ([username])
GO
ALTER TABLE [dbo].[Joint] CHECK CONSTRAINT [FK_Joint_User]
GO
ALTER TABLE [dbo].[MessFile]  WITH CHECK ADD  CONSTRAINT [FK_MessFile_Joint] FOREIGN KEY([id_joint])
REFERENCES [dbo].[Joint] ([id])
GO
ALTER TABLE [dbo].[MessFile] CHECK CONSTRAINT [FK_MessFile_Joint]
GO
ALTER TABLE [dbo].[MessText]  WITH CHECK ADD  CONSTRAINT [FK_MessText_Joint] FOREIGN KEY([id_joint])
REFERENCES [dbo].[Joint] ([id])
GO
ALTER TABLE [dbo].[MessText] CHECK CONSTRAINT [FK_MessText_Joint]
GO
