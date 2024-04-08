#include <iostream>
#include <fstream>
#include <vector>
#include <string>

class DataImporter {
public:
    DataImporter() = default;
    ~DataImporter() = default;

    bool ImportData(const std::string& filename, std::vector<std::string>& data) {
        std::ifstream file(filename);
        if (!file.is_open()) {
            std::cout << "Failed to open file: " << filename << std::endl;
            return false;
        }

        std::string line;
        while (std::getline(file, line)) {
            data.push_back(line);
        }

        file.close();
        return true;
    }
};

int main() {
    DataImporter importer;
    std::vector<std::string> myData;

    if (importer.ImportData("data.txt", myData)) {
        // 数据导入成功
        std::cout << "数据导入成功！" << std::endl;

        // 打印导入的数据
        for (const auto& item : myData) {
            std::cout << item << std::endl;
        }
    }

    return 0;
}
