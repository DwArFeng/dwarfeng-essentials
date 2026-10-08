# Compile By Source - 从源码编译

## 准备依赖

该项目的部分依赖不在中央仓库下，需要从其它仓库下载，或者下载源码自行编译。

### 使用其它仓库

您可以在 `settings.xml` 中添加如下配置，以使用其它仓库，通常 `settings.xml` 在 `$HOME/.m2/` 目录下。

```xml
<?xml version="1.0" encoding="UTF-8"?>

<settings
        xmlns="http://maven.apache.org/SETTINGS/1.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
        http://maven.apache.org/xsd/settings-1.0.0.xsd"
>

    <servers>
        <server>
            <id>xxx-releases</id>
            <username>your-username-here</username>
            <password>your-password-here</password>
        </server>
        <server>
            <id>rdc-snapshots</id>
            <username>your-username-here</username>
            <password>your-password-here</password>
        </server>
    </servers>

    <profiles>
        <profile>
            <id>xxx</id>
            <properties>
                <altReleaseDeploymentRepository>
                    xxx-releases::default::https://your-repository-url-here/
                </altReleaseDeploymentRepository>
                <altSnapshotDeploymentRepository>
                    xxx-snapshots::default::https://your-repository-url-here/
                </altSnapshotDeploymentRepository>
            </properties>
        </profile>
    </profiles>

    <activeProfiles>
        <activeProfile>xxx</activeProfile>
    </activeProfiles>
</settings>
```

使用的仓库需要保证有如下依赖，否则编译过程会因为找不到依赖而失败：

- com.dwarfeng:dutil
- com.dwarfeng:subgrade
- com.dwarfeng:spring-telqos
- com.dwarfeng:spring-terminator
- com.dwarfeng:dwarfeng-datamark
- com.dwarfeng:dwarfeng-ftp
- com.dwarfeng:dwarfeng-tmpstg
- com.dwarfeng:dcti
- com.dwarfeng:dwarfeng-dct
- com.dwarfeng:snowflake-distributed-service
- com.dwarfeng:account-keeper
- com.dwarfeng:rbac-distributed-service
- com.dwarfeng:buddy
- com.dwarfeng:settingrepo
- com.dwarfeng:notify
- com.dwarfeng:logic-engine
- com.dwarfeng:audit
- com.dwarfeng:fileio
- com.dwarfeng:voucher

### 下载依赖源码

您可以在 [Dwarfeng's Github](https://github.com/DwArFeng) 或 [Dwarfeng's Gitee](https://gitee.com/dwarfeng)
下载或克隆依赖的源码，然后使用 `mvn install` 命令将其安装到本地仓库中。

- com.dwarfeng:dutil

  github: [https://github.com/DwArFeng/dutil](https://github.com/DwArFeng/dutil)

  gitee: [https://gitee.com/dwarfeng/dutil](https://gitee.com/dwarfeng/dutil)


- com.dwarfeng:subgrade

  github: [https://github.com/DwArFeng/subgrade](https://github.com/DwArFeng/subgrade)

  gitee: [https://gitee.com/dwarfeng/subgrade](https://gitee.com/dwarfeng/subgrade)


- com.dwarfeng:spring-telqos

  github: [https://github.com/DwArFeng/spring-telqos](https://github.com/DwArFeng/spring-telqos)

  gitee: [https://gitee.com/dwarfeng/spring-telqos](https://gitee.com/dwarfeng/spring-telqos)


- com.dwarfeng:spring-terminator

  github: [https://github.com/DwArFeng/spring-terminator](https://github.com/DwArFeng/spring-terminator)

  gitee: [https://gitee.com/dwarfeng/spring-terminator](https://gitee.com/dwarfeng/spring-terminator)


- com.dwarfeng:dwarfeng-datamark

  github: [https://github.com/DwArFeng/dwarfeng-datamark](https://github.com/DwArFeng/dwarfeng-datamark)

  gitee: [https://gitee.com/dwarfeng/dwarfeng-datamark](https://gitee.com/dwarfeng/dwarfeng-datamark)


- com.dwarfeng:dwarfeng-ftp

  github: [https://github.com/DwArFeng/dwarfeng-ftp](https://github.com/DwArFeng/dwarfeng-ftp)

  gitee: [https://gitee.com/dwarfeng/dwarfeng-ftp](https://gitee.com/dwarfeng/dwarfeng-ftp)


- com.dwarfeng:dwarfeng-tmpstg

  github: [https://github.com/DwArFeng/dwarfeng-tmpstg](https://github.com/DwArFeng/dwarfeng-tmpstg)

  gitee: [https://gitee.com/dwarfeng/dwarfeng-tmpstg](https://gitee.com/dwarfeng/dwarfeng-tmpstg)


- com.dwarfeng:dcti

  github: [https://github.com/DwArFeng/dcti](https://github.com/DwArFeng/dcti)

  gitee: [https://gitee.com/dwarfeng/dcti](https://gitee.com/dwarfeng/dcti)


- com.dwarfeng:dwarfeng-dct

  github: [https://github.com/DwArFeng/dwarfeng-dct](https://github.com/DwArFeng/dwarfeng-dct)

  gitee: [https://gitee.com/dwarfeng/dwarfeng-dct](https://gitee.com/dwarfeng/dwarfeng-dct)


- com.dwarfeng:snowflake-distributed-service

  github: [https://github.com/DwArFeng/snowflake-distributed-service](https://github.com/DwArFeng/snowflake-distributed-service)

  gitee: [https://gitee.com/dwarfeng/snowflake-distributed-service](https://gitee.com/dwarfeng/snowflake-distributed-service)


- com.dwarfeng:account-keeper

  github: [https://github.com/DwArFeng/account-keeper](https://github.com/DwArFeng/account-keeper)

  gitee: [https://gitee.com/dwarfeng/account-keeper](https://gitee.com/dwarfeng/account-keeper)


- com.dwarfeng:rbac-distributed-service

  github: [https://github.com/DwArFeng/rbac-distributed-service](https://github.com/DwArFeng/rbac-distributed-service)

  gitee: [https://gitee.com/dwarfeng/rbac-distributed-service](https://gitee.com/dwarfeng/rbac-distributed-service)


- com.dwarfeng:buddy

  github: [https://github.com/DwArFeng/buddy](https://github.com/DwArFeng/buddy)

  gitee: [https://gitee.com/dwarfeng/buddy](https://gitee.com/dwarfeng/buddy)


- com.dwarfeng:settingrepo

  github: [https://github.com/DwArFeng/settingrepo](https://github.com/DwArFeng/settingrepo)

  gitee: [https://gitee.com/dwarfeng/settingrepo](https://gitee.com/dwarfeng/settingrepo)


- com.dwarfeng:notify

  github: [https://github.com/DwArFeng/notify](https://github.com/DwArFeng/notify)

  gitee: [https://gitee.com/dwarfeng/notify](https://gitee.com/dwarfeng/notify)


- com.dwarfeng:logic-engine

  github: [https://github.com/DwArFeng/logic-engine](https://github.com/DwArFeng/logic-engine)

  gitee: [https://gitee.com/dwarfeng/logic-engine](https://gitee.com/dwarfeng/logic-engine)


- com.dwarfeng:audit

  github: [https://github.com/DwArFeng/audit](https://github.com/DwArFeng/audit)

  gitee: [https://gitee.com/dwarfeng/audit](https://gitee.com/dwarfeng/audit)


- com.dwarfeng:fileio

  github: [https://github.com/DwArFeng/fileio](https://github.com/DwArFeng/fileio)

  gitee: [https://gitee.com/dwarfeng/fileio](https://gitee.com/dwarfeng/fileio)


- com.dwarfeng:voucher

  github: [https://github.com/DwArFeng/voucher](https://github.com/DwArFeng/voucher)

  gitee: [https://gitee.com/dwarfeng/voucher](https://gitee.com/dwarfeng/voucher)

## 下载源码

使用 git 进行源码下载。

```shell
git clone git@github.com:DwArFeng/dwarfeng-essentials.git
```

对于中国用户，可以使用 gitee 进行下载。

```shell
git clone git@gitee.com:dwarfeng/dwarfeng-essentials.git
```

## 项目编译、打包

进入项目根目录，执行 maven 命令。

```shell
mvn clean package
```

如果上述命令执行失败，请仔细阅读报错内容，绝大部分情况下是因为上述依赖缺失。请您重复上述步骤，直到编译成功。

## 寻找打包后的目标文件

找到打包后的目标文件

```
dwarfeng-essentials-distribute/target/distribute/dwarfeng-essentials-all-he/dwarfeng-essentials-all-he-${version}-release.tar.gz
```

如能找到该文件，则说明编译成功。
