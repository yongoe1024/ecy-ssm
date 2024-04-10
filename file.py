import os
# 用于将指定目录下的所有 .html 文件的后缀改成 .jsp
def change_file_extension(directory):
    # 遍历目录中的所有文件和子目录
    for root, dirs, files in os.walk(directory):
        for file in files:
            # 检查文件后缀是否为 .html
            if file.endswith('.jsp'):
                # 构造新文件名，将 .html 后缀改成 .jsp
                old_file_path = os.path.join(root, file)
                new_file_path = os.path.join(root, file.replace('.jsp', '.html'))
                # 重命名文件
                os.rename(old_file_path, new_file_path)
                print(f'Renamed: {old_file_path} -> {new_file_path}')

# 要遍历的目录路径
directory_path = '/Users/yongoe/code/github/ecy-ssm/ecy-server/src/main/webapp/page'
change_file_extension(directory_path)
