# Dwarfeng Essentials

Dwarfeng Essentials 是赵扶风的通用底座聚合项目，用于统一提供账户管理、权限管理、人员信息、配置仓库、通知等基础服务。

---

## 国际化（I18N）

您正在阅读的文档是中文文档，您可以在 [wiki](..) 目录下找到其他语言的文档。

You are reading the Chinese document, you can find documents in other languages in the [wiki](..) directory.

- [简体中文](./Introduction.md)
- [English](../en-US/Introduction.md)

## 特性

- 基于 Subgrade 构建，将多个基础服务聚合为统一的可执行节点。
- 提供账户注册、注销、登录、登出、登录状态派生与多端状态管理。
- 提供基于 RBAC 的角色权限管理、权限表达式与分布式缓存支持。
- 提供用户、资料、头像等人员信息的统一管理。
- 提供支持文本、图片、文件、国际化、导航等值类型的配置仓库。
- 提供通知主题、调度、路由、发送等通知服务。
- 提供实体维护服务与操作服务，调用方便。
- 提供 Telqos 运维平台，能够在没有 GUI 的环境下使用本服务的功能。
- 支持主流关系型数据库（基于 Hibernate），并使用 Redis 提供分布式缓存。
- 使用 FTP 服务器存储头像、图片、文件等二进制资源。
- 支持分布式部署。

## 文档

该项目的文档位于 [docs](../..) 目录下，包括：

### wiki

wiki 为项目的开发人员为本项目编写的详细文档，包含不同语言的版本，主要入口为：

1. [简介](./Introduction.md) - 即本文件。
2. [目录](./Contents.md) - 文档目录。

## 安装说明

1. 下载源码

   使用 git 进行源码下载。

   ```shell
   git clone git@github.com:DwArFeng/dwarfeng-essentials.git
   ```

   对于中国用户，可以使用 gitee 进行高速下载。

   ```shell
   git clone git@gitee.com:dwarfeng/dwarfeng-essentials.git
   ```

2. 项目打包

   进入项目根目录，执行 maven 命令。

   ```shell
   mvn clean package
   ```

3. 解压

   找到打包后的目标文件。

   ```
   dwarfeng-essentials-node/dwarfeng-essentials-node-all-he/target/dwarfeng-essentials-all-he-[version]-release.tar.gz
   ```

   将其解压至 windows 系统或者 linux 系统。

4. 配置

   1. 修改 `conf` 文件夹下的配置文件，着重修改各连接的 url 与密码。

5. enjoy it

## 分布式说明

该项目使用 `dubbo` 作为 RPC 框架，本身支持分布式，您可以在实际使用时，部署该项目任意数量，以进行分布式运算。
